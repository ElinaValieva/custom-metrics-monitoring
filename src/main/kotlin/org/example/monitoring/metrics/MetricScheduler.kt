package org.example.monitoring.metrics

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

@Component
class MetricScheduler(meterRegistry: MeterRegistry) {

    private var testGauge = meterRegistry.gauge("custom_gauge", AtomicInteger(0)) ?: AtomicInteger(0)
    private var testCounter: Counter = meterRegistry.counter("custom_counter")

    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    fun schedulingTask() {
        testGauge.set(getRandomNumberInRange(0, 100))
        testCounter.increment()
    }

    fun getRandomNumberInRange(min: Int, max: Int): Int {
        if (min >= max)
            throw IllegalArgumentException("max must be greater than min")
        return Random.nextInt((max - min) + 1) + min
    }
}