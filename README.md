create database seatbd;
<img width="760" height="62" alt="image" src="https://github.com/user-attachments/assets/be85d75e-a60e-4b31-97d7-f4b4db800e20" />
<img width="1900" height="865" alt="image" src="https://github.com/user-attachments/assets/f7905458-89e1-4f56-a4e5-f8c32b06ce47" />

Build Dockerfile
-----------------
docker build -t ticketbook-app .
docker login
docker tag -t ticketbook-app sravanscker/ticketbook-app:1.0
docker push sravanscker/ticketbook-app:1.0
---------------------------------------------------------
Deployment in Kubernetes 
-------------------------------------------------------------
kubectl apply -f secret.yml
kubectl apply -f configmap.yml
kubectl apply -f Deployment.yml
---------------------------------------------------------
Please update db password in configmap.yml
after that apply portforwad command to run
-------------------------------------------
kubectl port-forward service/springboot-service 8080:80
