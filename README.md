Compile and run tests
--- 

    mvn clean install

Run
---

    mvn spring-boot:run
    
Test
---

Open http://localhost:8084/filter/ABC

Build docker image 
---

	docker build -t masterdata:latest .

Run with docker
---

	docker run --network=host -p 8083:8083 masterdata:latest