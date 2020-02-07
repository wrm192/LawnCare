<h1> Repository for LawnCare mobile app for Jason Trask. </h1>

<h2> Package Details </h2>
<p> The package is set up with a "frontend" directory and a "backend". The frontend consister of an android application, and the backend is a Spring boot application</p>

<h2> Environment Details </h2>

<h3> Setting up Postgresql For MAC: </h3>

Step 1 - Install postgres locally, using homebrew: https://wiki.postgresql.org/wiki/Homebrew

Step 2 - Start the service, that link above can tell you how to start the service. You can verify it using network utility and check that something is listening on port 5432.

Step 3 - Set up Environment config on Intellij by going Edit Configurations -> Press the down Arrow on Environment -> Press the $ Symbol at the end of the row "Environment Variables" -> Add the following Variables atleast: 

DB_USER and set it to what ever the postgres user created was
DB_PASSWORD and set it to the password (default is no password)

How to check your DB_USER name: 
On terminal type: psql to open the postgres view 
and the command: \du

this will show the list of all users, copy the user name and set it as an environment variable. 

<h3> Setting up Postgresql For Windows: </h3>

If someone else wants to fill this out when they set it up for windows please do so, its should be similar minus step 1. 







