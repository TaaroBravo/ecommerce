# ecommerce
Ecommerce with microservices

# Commands

kubectl apply -f infrastructure

kubectl apply -f applications

kubectl port-forward svc/frontend 4200:80

kubectl port-forward svc/keycloak 8080:8080

kubectl port-forward svc/api-gateway 9000:9000
