# Spring-Boot-SnakeYAML2-Upgrade
This repository contains the required changes to upgrade any Spring Boot 2.x application to use SnakeYAML 2.0. When upgrading to SnakeYAML 2.0, the removal of a no-arg constructor causes compatibility issues with Spring Boot.

To address this issue, we have modified OriginTrackedYamlLoader to support the new version of SnakeYAML. We have also updated YamlPropertySourceLoader to use this modified class, and updated spring.factories to point to the new configuration.

## CustomOriginTrackedYamlLoader
CustomOriginTrackedYamlLoader is a modified version of YamlProcessor that loads .yml files into a map of String to OriginTrackedValue. This modified class uses OriginTrackingConstructor to track property origins, and also implements KeyScalarNode and NoTimestampResolver to ensure compatibility with SnakeYAML 2.0.

## CustomYamlPropertySourceLoader
CustomYamlPropertySourceLoader is a modified version of PropertySourceLoader that loads .yml and .yaml files into a PropertySource. This modified class uses CustomOriginTrackedYamlLoader to load the properties, and returns a list of OriginTrackedMapPropertySource.

## AppConfig
AppConfig is a simple configuration class that demonstrates how to use the new version of SnakeYAML. It reads the snake.yaml.version property and prints its value to the console.

## Usage
To use this repository, clone it and merge the changes into your Spring Boot project. Note that this repository is not intended to be a standalone project, but rather a set of modifications that can be applied to existing Spring Boot applications to enable compatibility with SnakeYAML 2.0.