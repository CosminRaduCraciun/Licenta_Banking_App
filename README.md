# Licenta_Banking_App

Proiect de licență: Automatizare BDD pentru testarea unei aplicații bancare

---

## Descriere generală

Acest proiect reprezintă o suită de teste automate pentru o aplicație bancară demo (https://www.globalsqa.com/angularJs-protractor/BankingProject/), folosind principiile BDD (Behavior Driven Development) cu Cucumber și Selenium WebDriver.

Scopul proiectului este de a demonstra cum se poate valida, automatizat, funcționalitatea principală a unei aplicații de tip banking: adăugarea de clienți, deschiderea de conturi, operațiuni pe cont (depuneri, retrageri), vizualizarea tranzacțiilor și autentificarea utilizatorilor.

---

## Tehnologii folosite

- **Java 8+**
- **Selenium WebDriver**
- **Cucumber BDD**
- **JUnit 5**
- **WebDriverManager**
- **Maven** (gestionare dependențe)
- **Page Object Model** pentru organizarea codului

---

## Structura proiectului

- `src/test/java/pages/` – Modele Page Object pentru fiecare pagină din aplicația web testată
- `src/test/java/stepDefinition/` – Definirea pașilor (steps) pentru scenariile BDD
- `src/test/resources/features/` – Fișiere `.feature` cu scenarii Gherkin pentru fiecare funcționalitate testată
- `src/test/java/config/` – Configurare Selenium/WebDriver, hooks pentru inițializare/cleanup
- `src/test/java/utils/` – Utilitare pentru citirea fișierelor de configurare, property reader
- `pom.xml` – Configurare Maven și dependențe

---

## Cum rulezi testele?

1. **Clonează proiectul:**
   ```bash
   git clone https://github.com/CosminRaduCraciun/Licenta_Banking_App.git
   cd Licenta_Banking_App/BankingApp
   ```

2. **Instalează dependențele:**
   ```bash
   mvn clean install
   ```

3. **Configurează browserul (opțional):**
   - Modifică fișierul `src/test/resources/config.properties` pentru a alege browserul (`chrome` sau `edge`).

4. **Rulează testele:**
   ```bash
   mvn test
   ```

5. **Vizualizează rapoartele:**
   - Rapoartele Cucumber HTML se vor găsi în `target/cucumber-html-reports/`.

---

## Exemple de scenarii acoperite

- Adăugarea unui client nou
- Deschiderea unui cont bancar pentru clientul respectiv
- Login ca utilizator client
- Depunere și retragere de fonduri
- Verificarea soldului și a tranzacțiilor
- Validarea mesajelor de succes și a erorilor

---

## Structura logică a datelor (simulare)

Deși aplicația demo nu folosește o bază de date reală, structura logică simulată cuprinde tabele de tipul:
- **Customers:** id, first_name, last_name, postcode
- **Accounts:** id, customer_id, currency, balance
- **Transactions:** id, account_id, date, amount, type (Credit/Debit)

---

## Contribuții și suport

Acest proiect a fost dezvoltat ca lucrare de licență la [numele facultății/universității tale].

Dacă ai întrebări, poți deschide un issue sau mă poți contacta la [adresa ta de email, dacă dorești].

---

## Licență

Proiectul este destinat exclusiv uzului academic și demonstrativ.
