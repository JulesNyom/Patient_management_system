# Dockerfile
FROM postgres:latest

# Variables d'environnement pour la configuration PostgreSQL
ENV POSTGRES_USER=admin_user
ENV POSTGRES_PASSWORD=password
ENV POSTGRES_DB=db

# Exposer le port PostgreSQL par défaut
EXPOSE 5432

# Vous pouvez ajouter des scripts SQL d'initialisation dans /docker-entrypoint-initdb.d/
# COPY init.sql /docker-entrypoint-initdb.d/