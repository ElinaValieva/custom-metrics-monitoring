package org.example.monitoring.metrics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomMetricsMonitoringApplication

fun main(args: Array<String>) {
	runApplication<CustomMetricsMonitoringApplication>(*args)
}
