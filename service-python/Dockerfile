# Base image com Python
FROM python:3.11-slim

# Define diretório de trabalho
WORKDIR /app

# Copia requirements se você tiver
COPY requirements.txt .

# Instala dependências (FastAPI, Uvicorn e Consul client)
RUN pip install --no-cache-dir -r requirements.txt \
    && pip install --no-cache-dir fastapi uvicorn python-consul

# Copia o restante do código da aplicação
COPY . .

# Expõe a porta do serviço (ajuste se necessário)
EXPOSE 8083

# Comando de inicialização
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8083"]
