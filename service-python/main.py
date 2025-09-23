from fastapi import FastAPI
import uvicorn
import os
import socket
from consul import Consul

app = FastAPI(
    title="Python Microservice API",
    description="API do microserviço Python integrada ao Consul",
    version="1.0.0"
)

@app.on_event("startup")
def register_service() -> None:
    consul_host = os.getenv("SPRING_CLOUD_CONSUL_HOST", "consul")
    consul_port = int(os.getenv("SPRING_CLOUD_CONSUL_PORT", "8500"))
    service_name = os.getenv("SERVICE_NAME", "sp")
    service_id = os.getenv("SERVICE_ID", service_name)
    service_port = int(os.getenv("SERVICE_PORT", "8083"))
    service_address = socket.gethostbyname(socket.gethostname())
    consul = Consul(host=consul_host, port=consul_port)
    consul.agent.service.register(
        name=service_name,
        service_id=service_id,
        address=service_address,
        port=service_port,
    )

@app.get("/python/hello")
def hello() -> dict:
    return {"message": "Hello from Python Service!"}

@app.post("/python/echo")
def echo(msg: dict) -> dict:
    return {"received": msg}

if __name__ == "__main__":
    port = int(os.getenv("SERVICE_PORT", "8083"))
    uvicorn.run(app, host="0.0.0.0", port=port)
