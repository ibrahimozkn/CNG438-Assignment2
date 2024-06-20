
# Two-Phase Cipher

This Java application implements a combination of two classic ciphers for encryption and decryption:

1. **Vigenère Cipher**: A polyalphabetic substitution cipher that uses a keyword to shift letters according to a specific pattern.
2. **Columnar Transposition Cipher**: A transposition cipher that rearranges letters based on a key to create the ciphertext.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Usage](#usage)
  - [Encrypt](#encrypt)
  - [Decrypt](#decrypt)
  - [Exit](#exit)
- [Prompt Instructions](#prompt-instructions)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## Introduction

This project is a Java-based encryption and decryption tool that combines the Vigenère and Columnar Transposition ciphers. The two-phase encryption process ensures a higher level of security by applying both substitution and transposition techniques.

## Features

- **Encrypt**: Encrypt a plaintext message using the combined ciphers.
- **Decrypt**: Decrypt a ciphertext message using the combined ciphers.
- **Exit**: Terminate the program.

## Usage

### Encrypt

Encrypt a plaintext message using the combined ciphers.

### Decrypt

Decrypt a ciphertext message using the combined ciphers.

### Exit

Terminate the program.

## Prompt Instructions

1. **Encrypt**:
   - Enter the plaintext or ciphertext message you want to work with.
   - Provide a key, which is a sequence of characters used for encryption/decryption.
   - The program will display the encrypted or decrypted result based on your selection.

2. **Decrypt**:
   - Follow similar steps as encryption to decrypt a message.

3. **Exit**:
   - Terminate the program by selecting this option.

## Project Structure

```bash
.
├── .idea                   # IDE-specific settings
├── out                     # Output directory for compiled classes
├── src                     # Source code directory
│   ├── Main.java           # Main entry point of the application
│   ├── VigenereCipher.java # Vigenère Cipher implementation
│   └── ColumnarCipher.java # Columnar Transposition Cipher implementation
├── ibrahimOzkanAssignment2.iml # IntelliJ IDEA project file
└── README.md               # Project documentation
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.
