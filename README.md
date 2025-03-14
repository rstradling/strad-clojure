# campaigns 

Right now just messing around with creating a clojure app as it has been a while.  Purpose is to explore an opensource Campaign library 

## Usage

### Running locally

#### Prerequisites

* Install [colima](https://github.com/abiosoft/colima) or some other way to use containerd images and kubernetes.
* Install nerdctl

#### Building

Build the docker image.  Please *note* if using colima you must specify the image namespace to be `k8s.io` for the kubernetes resources to find it
```
nerdctl build -f Dockerfile -t campaigns:latest --namespace k8s.io .
```

#### Running

```
kubectl create namespace campaigns
kubectl apply -k kubes/overlays/local
```

