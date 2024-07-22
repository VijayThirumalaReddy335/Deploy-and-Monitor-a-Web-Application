# Containerized Microservice

This repository contains a simple Spring Boot application that is containerized using Docker and deployed on a Kubernetes cluster. The CI/CD pipeline is managed by Jenkins, and the infrastructure is provisioned using Terraform.

## Project Structure

- `src/main/java/com/example/Containerized/microservice/ContainerizedMicroserviceApplication.java`: The main application class.
- `src/main/java/com/example/Containerized/microservice/FirstApplication/Controller/FirstApplication.java`: The REST controller.
- `src/main/java/com/example/Containerized/microservice/FirstApplication/dto/Messagedto.java`: DTO class.
- `src/main/resources/application.properties`: Application configuration file.
- `Dockerfile`: Docker configuration file.
- `pom.xml`: Maven configuration file.
- `Jenkinsfile`: Jenkins pipeline script.
- `k8s/Kubernetes_FirstApplication.yaml`: Kubernetes deployment and service configuration.
- `terraform/`: Terraform configuration files for infrastructure provisioning.
- `ansible/playbook.yml`: Ansible playbook to install and run Docker.

## Prerequisites

- Java 17
- Maven
- Docker
- Kubernetes cluster
- Terraform
- Ansible
- Jenkins

## Setup Instructions

### Step 1: Build the Spring Boot Application

1. Clone the repository:
    ```bash
    git clone https://github.com/VijayThirumalaReddy335/Deploy-and-Monitor-a-Web-Application.git
    cd Deploy-and-Monitor-a-Web-Application
    ```

2. Build the application using Maven:
    ```bash
    mvn clean package
    ```

### Step 2: Create Docker Image

1. Build the Docker image:
    ```bash
    docker build -t vijaythirumalareddy335/first-application:latest .
    ```

2. Push the Docker image to Docker Hub:
    ```bash
    docker login
    docker push vijaythirumalareddy335/first-application:latest
    ```

### Step 3: Deploy with Kubernetes

1. Apply the Kubernetes deployment and service configuration:
    ```bash
    kubectl apply -f k8s/Kubernetes_FirstApplication.yaml
    ```

### Step 4: Infrastructure Provisioning with Terraform

1. Navigate to the Terraform directory:
    ```bash
    cd terraform
    ```

2. Initialize Terraform:
    ```bash
    terraform init
    ```

3. Validate the Terraform configuration:
    ```bash
    terraform validate
    ```

4. Create a Terraform plan:
    ```bash
    terraform plan
    ```

5. Apply the Terraform plan:
    ```bash
    terraform apply
    ```

### Step 5: Jenkins Pipeline

1. Ensure Jenkins is installed and running.
2. Create a new Jenkins pipeline job and configure it to use the `Jenkinsfile` in the repository.

### Jenkinsfile Overview

**Environment Variables:**

- `DOCKER_CREDENTIALS_ID`: The credentials ID for Docker Hub.
- `DOCKER_IMAGE`: The Docker image name.

**Stages:**

1. **Checkout**: Clones the Git repository.
2. **Code Linting and Unit Tests**: Lints the code using Maven Checkstyle and runs unit tests.
3. **Build with Maven**: Packages the application using Maven.
4. **Build Docker Image**: Builds the Docker image.
5. **Push Docker Image**: Pushes the Docker image to Docker Hub using the specified credentials.
6. **Infrastructure Provisioning with Terraform**: Initializes and applies Terraform configurations for infrastructure provisioning.
7. **Deploy to Kubernetes**: Applies Kubernetes deployment and service configurations using the provided kubeconfig credentials.

**Post Actions:**

- **always**: Cleans the workspace.
- **success**: Prints a success message.
- **failure**: Prints a failure message.

This pipeline provides a robust CI/CD process, covering code linting, unit testing, Docker image creation, pushing to Docker Hub, infrastructure provisioning, and deployment to Kubernetes.

## Application Endpoints

- `/hello`: Returns a JSON response with the message "Hello world".

## Configuration

- `spring.application.name`: Sets the application name.
- `server.port`: Sets the application port.

## Dockerfile

- Based on `openjdk:17` image.
- Copies the JAR file to the image and runs it.

## Kubernetes Deployment and Service

- **Deployment**: Defines a deployment with 1 replica.
- **Service**: Exposes the application on port 80.

## Terraform Configuration

- Provisions a VPC, subnet, security group, and an EC2 instance.

## Ansible Playbook

- Installs Docker and runs the container on the provisioned instance.

---

This project demonstrates a complete workflow from development to deployment using modern DevOps practices.
