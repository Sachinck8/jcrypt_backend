jcrypt – Java & Spring Boot Encryption Engine

A complete cryptography backend built using Java & Spring Boot.
This project provides secure AES, DES, and RSA implementations with clean, modular services and REST APIs.

Live Deployment

Your project is fully deployed and accessible online:

👉 Live API Base URL:

https://jcrypt-backend.onrender.com/swwager-ui/index.html


⭐ Features

🔒 AES – Encrypt & Decrypt

🔒 DES – Encrypt & Decrypt

🔑 RSA – Key pair generation + Encrypt/Decrypt

🧩 Separate Key Generation Service

🧩 Separate Encryption/Decryption Service

📡 Live REST APIs (hosted on Render)

🔄 Base64 encoded keys & ciphertext

🏗️ Clean, scalable project architecture

📂 Project Structure

jcrypt_backend/
 ├── src/main/java/com/jcrypt/backend/
 │    ├── controller/         → API Controllers
 │    ├── service/
 │    │     ├── keyservice/   → AES/DES/RSA Key Generation
 │    │     └── cryptoservice/→ Encryption & Decryption Logic
 │    ├── crypto/             → Crypto Utility Classes
 │    └── dto/                → Request & Response Models
 └── src/main/resources/
      └── application.properties



🚀 Tech Stack

Java 17+

Spring Boot

Java Cryptography Extension (JCE)

Maven

Base64 Encoding

Render (Cloud Deployment)


API Endpoints

Use your Render URL + endpoints below.

Example:

https://jcrypt_backend.onrender.com/swwager-ui/index.html/aes/key


---

AES

Method	Endpoint	Description

GET	/aes/key	Generate AES Key
POST	/aes/encrypt	Encrypt plaintext
POST	/aes/decrypt	Decrypt ciphertext



---

DES

Method	Endpoint	Description

GET	/des/key	Generate DES Key
POST	/des/encrypt	Encrypt plaintext
POST	/des/decrypt	Decrypt ciphertext



---

RSA

Method	Endpoint	Description

GET	/rsa/generate-keys	Generate RSA Key Pair
POST	/rsa/encrypt	Encrypt using public key
POST	/rsa/decrypt	Decrypt using private key



---

📬 Sample AES Encryption Request

POST /aes/encrypt
{
  "plainText": "Hello World",
  "key": "BASE64_ENCODED_AES_KEY"
}

Sample Response

{
  "cipherText": "s7aD92lkLA03sA..."
}


---

🧪 Run Locally (Optional)

1️⃣ Clone the repository

git clone https://github.com/sachinck8/jcrypt_backend
cd jcrypt_backend

2️⃣ Run the application

mvn spring-boot:run

3️⃣ Access local APIs

http://localhost:8080


---

🚀 Future Enhancements

Add web UI for encryption testing

Add Blowfish / ChaCha20

Add JWT-based authentication

Add Docker support

Add more request validation



---

👨‍💻 Author

Sachin Kshirsagar
Java Backend Developer

🔗 GitHub: https://github.com/sachinck8
🌐 Live API: (https://jcrypt-backend.onrender.com/swwager-ui/index.html)
💼 Open to Backend / Java roles


---

⭐ Support

If you find this project useful, please ⭐ star the repository!

# jcrypt_backend
