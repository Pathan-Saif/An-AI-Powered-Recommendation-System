# AI Recommendation System

A production-oriented AI-powered recommendation platform built using **Spring Boot**, **FastAPI**, **PostgreSQL**, and **Machine Learning**. The system collects user interaction data, trains recommendation models, and generates personalized recommendations through a microservices architecture.

---

## Overview

This project demonstrates how modern recommendation systems used by companies like Amazon, Netflix, YouTube, and Spotify can be implemented using a scalable backend architecture.

The platform consists of:

* React Frontend
* Spring Boot API Gateway & Business Layer
* FastAPI Machine Learning Microservice
* PostgreSQL Database
* Recommendation Engine using Collaborative Filtering

The system tracks user interactions such as views, clicks, likes, and purchases, then uses this data to generate personalized recommendations.

---

## Architecture

```text
+--------------------+
|   React Frontend   |
+---------+----------+
          |
          v
+--------------------+
|   Spring Boot API  |
| Authentication     |
| Business Logic     |
| REST APIs          |
+---------+----------+
          |
          v
+--------------------+
| FastAPI ML Service |
| Recommendation     |
| Training Engine    |
+---------+----------+
          |
          v
+--------------------+
| PostgreSQL DB      |
+--------------------+
```

---

## Features

### Authentication & User Management

* User Registration
* User Login
* JWT Authentication
* Secure API Access

### User Interaction Tracking

The system records:

* Product Views
* Click Events
* Likes
* Cart Actions
* Purchases

Each interaction is converted into weighted ML training data.

### Machine Learning

* Item-Based Collaborative Filtering
* Cosine Similarity Recommendation Engine
* Dynamic User-Item Matrix Generation
* Model Training Endpoint
* Top-K Recommendation Generation

### Recommendation Features

* Personalized Recommendations
* Similar Item Discovery
* User Preference Learning
* Real-Time Recommendation API

### Production Features

* Microservices Architecture
* RESTful APIs
* Docker Support
* PostgreSQL Persistence
* Service Health Monitoring
* Modular Design

---

## Technology Stack

### Frontend

* React.js
* Axios
* React Router

### Backend

* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA

### Machine Learning Service

* FastAPI
* Pandas
* NumPy
* Scikit-Learn

### Database

* PostgreSQL

### DevOps

* Docker
* Docker Compose

---

## Project Structure

```text
ai-recommendation-system
│
├── frontend
│   ├── React Application
│
├── springboot-backend
│   ├── Controllers
│   ├── Services
│   ├── Repositories
│   ├── Entities
│   ├── Security
│   └── DTOs
│
├── ml-service
│   ├── app.py
│   ├── recommender.py
│   ├── database.py
│   ├── models.py
│   ├── utils.py
│   └── requirements.txt
│
└── docker-compose.yml
```

---

## Recommendation Workflow

### Step 1

User performs actions:

```text
View Product
Click Product
Purchase Product
```

### Step 2

Spring Boot records interaction data.

### Step 3

ML Service stores interaction history.

### Step 4

Training endpoint generates a user-item matrix.

### Step 5

Collaborative filtering algorithm calculates similarity scores.

### Step 6

Top-K recommendations are generated.

### Step 7

Recommendations are returned to the frontend.

---

## API Documentation

### Health Check

```http
GET /health
```

Response

```json
{
  "status": "ml-service is running"
}
```

---

### Save Interaction

```http
POST /interaction
```

Request

```json
{
  "userId": 1,
  "externalItemId": "product_12",
  "eventType": "view"
}
```

Response

```json
{
  "status": "saved"
}
```

---

### Train Model

```http
POST /train
```

Response

```json
{
  "status": "model_trained",
  "total_interactions": 250
}
```

---

### Get Recommendations

```http
GET /recommend/1?k=10
```

Response

```json
{
  "recommendations": [
    {
      "externalId": "product_22",
      "score": 0.92
    },
    {
      "externalId": "product_44",
      "score": 0.84
    }
  ]
}
```

---

## Machine Learning Approach

### Collaborative Filtering

The recommendation engine uses Item-Based Collaborative Filtering.

Workflow:

1. Build User-Item Matrix
2. Calculate Item Similarity
3. Generate Similarity Scores
4. Rank Recommendations
5. Return Top-K Items

### Similarity Metric

```text
Cosine Similarity
```

Benefits:

* Fast
* Interpretable
* Scalable
* Suitable for sparse datasets

---

## Running the ML Service

Install dependencies:

```bash
pip install -r requirements.txt
```

Run service:

```bash
uvicorn app:app --reload --port 8000
```

Swagger Documentation:

```text
http://localhost:8000/docs
```

---

## Running Spring Boot

```bash
mvn clean install
mvn spring-boot:run
```

Application:

```text
http://localhost:8084
```

---

## Running Frontend

```bash
npm install
npm start
```

Application:

```text
http://localhost:3000
```

---

## Future Enhancements

* Hybrid Recommendation System
* Content-Based Filtering
* Deep Learning Recommendations
* User Embeddings
* Redis Caching
* Kafka Event Streaming
* Model Retraining Scheduler
* Recommendation Analytics Dashboard
* A/B Testing Framework

---

## Resume Highlights

* Developed a microservices-based AI recommendation platform using Spring Boot and FastAPI.
* Implemented collaborative filtering and cosine similarity algorithms for personalized recommendations.
* Built REST APIs for user interaction tracking, model training, and recommendation serving.
* Designed scalable PostgreSQL-backed architecture for storing interaction data.
* Integrated machine learning services with enterprise-grade backend APIs.

---

## Author

MD Saif Ali Khan

B.Tech Computer Science Engineering

AI & Backend Development Enthusiast
