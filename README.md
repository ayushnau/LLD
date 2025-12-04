# LLD-LowLevelDesign

A comprehensive collection of Low-Level Design (LLD) examples and interview questions implemented in Java, covering:
- Design Patterns (Creational, Structural, Behavioral)
- SOLID Principles
- System Design Problems (ATM, BookMyShow, Parking Lot, Elevator, etc.)

## Requirements

- **Java 21** (as specified in `pom.xml`)
- **Maven 3.6+** (for dependency management and building)

## Installation & Setup

### Step 1: Install Java 21

**macOS (using Homebrew):**
```bash
brew install openjdk@21
# Add to PATH (add this to your ~/.zshrc or ~/.bash_profile)
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
export PATH="$JAVA_HOME/bin:$PATH"
```

**macOS (Manual Installation):**
1. Download from [Eclipse Temurin (Adoptium)](https://adoptium.net/temurin/releases/?version=21) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java21)
2. Install the `.dmg` file
3. Set JAVA_HOME:
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-21-jdk
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

**Linux (CentOS/RHEL):**
```bash
sudo yum install java-21-openjdk-devel
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
export PATH="$JAVA_HOME/bin:$PATH"
```

**Windows:**
1. Download Java 21 from [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=21) or [Oracle](https://www.oracle.com/java/technologies/downloads/#java21)
2. Run the installer
3. Set JAVA_HOME environment variable:
   - Right-click "This PC" → Properties → Advanced System Settings → Environment Variables
   - Add new System Variable: `JAVA_HOME` = `C:\Program Files\Java\jdk-21`
   - Add to Path: `%JAVA_HOME%\bin`

**Verify Java Installation:**
```bash
java -version
# Should show: openjdk version "21" or java version "21"
javac -version
# Should show: javac 21
```

### Step 2: Install Maven

**macOS (using Homebrew):**
```bash
brew install maven
```

**macOS/Linux (Manual Installation):**
1. Download from [Maven Website](https://maven.apache.org/download.cgi) (download the `apache-maven-3.x.x-bin.tar.gz`)
2. Extract to a directory (e.g., `/usr/local/apache-maven` or `~/apache-maven`)
3. Add to PATH:
```bash
export M2_HOME=/usr/local/apache-maven
export PATH="$M2_HOME/bin:$PATH"
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt install maven
```

**Linux (CentOS/RHEL):**
```bash
sudo yum install maven
```

**Windows:**
1. Download Maven from [Maven Website](https://maven.apache.org/download.cgi)
2. Extract to a folder (e.g., `C:\Program Files\Apache\maven`)
3. Add to Environment Variables:
   - `M2_HOME` = `C:\Program Files\Apache\maven`
   - Add to Path: `%M2_HOME%\bin`

**Verify Maven Installation:**
```bash
mvn -version
# Should show Maven version and Java version 21
```

### Step 3: Build the Project

```bash
# Navigate to project directory
cd /path/to/lld-lowleveldesign

# Build the project (downloads dependencies and compiles)
mvn clean compile
```

## How to Run the Project

### Method 1: Using Maven (Command Line)

**Run any demo class:**
```bash
mvn exec:java -Dexec.mainClass="com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp"
```

**Or compile first, then run:**
```bash
# Compile
mvn compile

# Run using Java directly (macOS/Linux)
java -cp "target/classes:$(mvn dependency:build-classpath -q -Dmdep.outputFile=/dev/stdout)" com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp

# Run using Java directly (Windows)
mvn dependency:build-classpath -Dmdep.outputFile=classpath.txt
java -cp "target/classes;$(type classpath.txt)" com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp
```

### Method 2: Using IDE (Recommended for Development)

**IntelliJ IDEA:**
1. Open IntelliJ IDEA
2. File → Open → Select the project folder (`lld-lowleveldesign`)
3. IntelliJ will auto-detect it as a Maven project
4. Wait for dependencies to download (check bottom-right status)
5. Navigate to any class with `main()` method
6. Right-click the class → "Run 'ClassName.main()'"
   - Or click the green ▶️ icon next to the `main()` method

**VS Code:**
1. Install extensions:
   - "Extension Pack for Java" (by Microsoft)
   - "Maven for Java" (by Microsoft)
2. Open the project folder: File → Open Folder → Select `lld-lowleveldesign`
3. VS Code will detect Maven project and download dependencies
4. Open any `.java` file with `main()` method
5. Click the "Run" button above the `main()` method
   - Or press `F5` to debug

**Eclipse:**
1. File → Import → Maven → Existing Maven Projects
2. Browse and select the project folder
3. Click "Finish"
4. Wait for Maven to download dependencies
5. Navigate to any class with `main()` method
6. Right-click → Run As → Java Application

## Available Demo Classes

This project contains 69+ demo classes. Here are some popular ones:

### Interview Questions:
- `com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp`
- `com.conceptcoding.interviewquestions.parkinglot.ParkingLotDemo`
- `com.conceptcoding.interviewquestions.elevator.Demo`
- `com.conceptcoding.interviewquestions.splitwise.Demo`
- `com.conceptcoding.interviewquestions.tictactoe.PlayGame`
- `com.conceptcoding.interviewquestions.chess.ChessDemo`
- `com.conceptcoding.interviewquestions.atm.ATMRoomComponents.ATMRoom`

### Design Patterns:
- `com.conceptcoding.behavioralpatterns.observer.notifymefeature.ECommerceStockNotificationApp`
- `com.conceptcoding.behavioralpatterns.strategy.paymentmethods.solution.Demo`
- `com.conceptcoding.creationalpatterns.singleton.SingletonDemo`
- `com.conceptcoding.structuralpatterns.facade.ECommerceApp`

### SOLID Principles:
- `com.conceptcoding.video1solid.singleresponsibility.solution.SolutionDemo`
- `com.conceptcoding.video1solid.openclosed.solution.SolutionDemo`
- `com.conceptcoding.video1solid.liskovsubstitution.example1.solution.Demo`

## Quick Start Example

```bash
# After setting up environment, run this:
mvn compile exec:java -Dexec.mainClass="com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp"
```

## Project Structure

```
src/main/java/com/conceptcoding/
├── behavioralpatterns/    # Behavioral design patterns
├── creationalpatterns/    # Creational design patterns
├── structuralpatterns/    # Structural design patterns
├── interviewquestions/    # LLD interview problems
├── video1solid/          # SOLID principles examples
└── additionalpatterns/   # Additional patterns (MVC, Null Object)
```

## Troubleshooting

**Issue: Java version mismatch**
```bash
# Check current Java version
java -version

# If not Java 21, set JAVA_HOME (macOS)
export JAVA_HOME=$(/usr/libexec/java_home -v 21)

# Verify
java -version  # Should show version 21
```

**Issue: Maven not found**
```bash
# Check if Maven is installed
mvn -version

# If not found, add to PATH (macOS/Linux)
export PATH="/usr/local/apache-maven/bin:$PATH"

# Or install via Homebrew (macOS)
brew install maven
```

**Issue: Dependencies not downloading**
```bash
# Force update dependencies
mvn clean install -U

# Or clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean compile
```

**Issue: "Class not found" or compilation errors**
```bash
# Clean and rebuild
mvn clean compile

# If using IDE, refresh Maven project:
# IntelliJ: Right-click pom.xml → Maven → Reload Project
# Eclipse: Right-click project → Maven → Update Project
```

**Issue: Permission denied (macOS/Linux)**
```bash
# Make sure you have execute permissions
chmod +x <script-name>
```

## Contributing

Feel free to contribute by adding more examples or improving existing ones!

---

## Additional Resources

- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Design Patterns Reference](https://refactoring.guru/design-patterns)
