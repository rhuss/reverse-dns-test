# Simple Reverse DNS lookup test

Setup your OpenShift connection (`oc get pods` should wokd), then deploy this with 

`
mvn fabric8:deploy
`

This will reverse lookup by default the kubernetes API services.

Set an explicit IP address with 

`
oc set env dc/reverse-dns-test DNS_CHECK_IP=10.1.5.1
`

for testing the reverse lookup as seen by Java's `InetAddress.getHostname()`.

See the source for more info.