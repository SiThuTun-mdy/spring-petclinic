### Building and running your application

When you're ready, start your application by running:
`docker compose up --build`.

Your application will be available at http://localhost:8080.

### Deploying your application to the cloud

First, build your image, e.g.: `docker build -t myapp .`.
If your cloud uses a different CPU architecture than your development
machine (e.g., you are on a Mac M1 and your cloud provider is amd64),
you'll want to build the image for that platform, e.g.:
`docker build --platform=linux/amd64 -t myapp .`.

Then, push it to your registry, e.g. `docker push myregistry.com/myapp`.

Add test stage to run test while building the image.

`docker build -t java-docker-image-test --progress=plain --no-cache --target=test .`

CI/CD pipelines can be set up to build and push your image to a registry

Create Repository variable in GitHub
DOCKER_USERNAME : docker ID

Create Repository secret in GitHub
DOCKERHUB_TOKEN : PAT of Docker Hub

Consult Docker's [getting started](https://docs.docker.com/go/get-started-sharing/)
docs for more detail on building and pushing.
