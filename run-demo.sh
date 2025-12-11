#!/bin/bash

# Script to easily run any demo class using Docker
# Usage: ./run-demo.sh <fully-qualified-class-name>
# Example: ./run-demo.sh com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp

if [ -z "$1" ]; then
    echo "============================================"
    echo "  LLD Low Level Design - Demo Runner"
    echo "============================================"
    echo ""
    echo "Usage: ./run-demo.sh <class-name>"
    echo ""
    echo "Popular demos:"
    echo "  ./run-demo.sh com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp"
    echo "  ./run-demo.sh com.conceptcoding.interviewquestions.parkinglot.ParkingLotDemo"
    echo "  ./run-demo.sh com.conceptcoding.interviewquestions.elevator.Demo"
    echo "  ./run-demo.sh com.conceptcoding.interviewquestions.splitwise.Demo"
    echo "  ./run-demo.sh com.conceptcoding.interviewquestions.chess.ChessDemo"
    echo "  ./run-demo.sh com.conceptcoding.behavioralpatterns.observer.notifymefeature.ECommerceStockNotificationApp"
    echo "  ./run-demo.sh com.conceptcoding.creationalpatterns.singleton.SingletonDemo"
    echo ""
    exit 1
fi

CLASS_NAME=$1

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo "Error: Docker is not installed. Please install Docker first."
    echo "Download from: https://www.docker.com/products/docker-desktop/"
    exit 1
fi

# Check if Docker is running
if ! docker info &> /dev/null; then
    echo "Error: Docker is not running. Please start Docker Desktop first."
    exit 1
fi

# Build image if it doesn't exist
if ! docker images | grep -q "lld-project"; then
    echo "Building Docker image (this may take 2-3 minutes on first run)..."
    docker build -t lld-project .
fi

# Run the specified class using Maven exec
echo ""
echo "Running: $CLASS_NAME"
echo "============================================"
docker run --rm lld-project mvn exec:java -Dexec.mainClass="$CLASS_NAME" -q

