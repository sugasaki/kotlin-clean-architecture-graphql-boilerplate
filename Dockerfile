# Use the official gradle image to create a build artifact.
FROM gradle:7.1 as builder

# Copy local code to the container image.
# Buildに必要ない不要なファイル群は .dockerignore に定義済
COPY . .

# # Build a release artifact.
# RUN gradle installDist
RUN gradle installShadowDist


# deploy
FROM amazoncorretto:11.0.9
EXPOSE 8080:8080
RUN mkdir /app
COPY --from=builder /home/gradle/infrastructure/build/install/* /app/
WORKDIR /app/bin/
CMD ["./infrastructure"]
