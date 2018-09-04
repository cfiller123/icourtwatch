# CourtWatch

CourtWatch is a web application that allows volunteers to add and edit court watching data (e.g., judge behavior and court outcomes in domestic violence charges) and managers to analyze and download all data. It boasts Spring Security to authenticate users, hashes passwords to reduce risk to users if database is exposed, has different roles for volunteers and managers, and uses JavaScript to provide dynamic charts and confirms permanent actions (deletes, edits) and enable downloading of files.

### Built With

Java SE 8, Spring Security, JavaScript ThymeLeaf, and mySQL.

### Getting Started

You can see a demo version here: https://courtwatchapp.herokuapp.com. To run your own version, you will need to create a local or remote database and edit your database login credentials. Currently, you will need to manually provide permissions for managers through direct editing of the database. In the User table, a "0" means that the user is a volunteer; a "1" provides the individual with manager level access. Future versions will allow web-based alternatives to direct database management.

### Author

Carl Filler

#### Licence

Copyright 2018, Carl Filler

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
