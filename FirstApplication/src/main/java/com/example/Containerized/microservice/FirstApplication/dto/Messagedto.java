package com.example.Containerized.microservice.FirstApplication.dto;

public class Messagedto {
	
	
        private String id;
        private String message;

        public Messagedto(String id, String message) {
            this.id = id;
            this.message = message;
        }

        public String getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }
    }


