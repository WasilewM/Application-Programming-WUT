# PAP21Z-Z17

Team members:  
Kędra Jan  
Kowalczyk Maciej  
Ściseł Bartłomiej  
Wasilewski Mateusz  
----------------------------------------------------------------------------------------------------------------------------------------------------
Specyfikacja projektu  
  
Wymagania względem aplikacji  
-	Aplikacja musi posiadać funckjonalność umożliwiającą automatyczne pokładowanie pasażerów oraz załogi do samolotu  
-	Aplikacja musi posiadać intuicyjny intefejs graficzny  
-	Aplikacja musi współpracować z bazą danych zaprojektowaną w modelu relacyjnym  
  
Opis działania aplikacji  
Aplikacja będzie posiadać zdefiniowane typy klas (typów obiektów do przechowywania w bazie danych):  
-	Człowiek  
-	Pasażer - dziedziczy po klasie Człowiek  
-	Załoga - dziedziczy po klasie Człowiek  
-	Lot  
-	Lotnisko  
-	Samolot  
-	Bilet 
-	Pozycja - w rozumieniu stanowisko pracy   
  
W celu symulacji ruchu pasażerskiego i lotniczego na lotnisku. Aplikacja będzie operować na danych pobieranych z bazy danych (która będzie integralną częścią aplikacji) jak również tych wprowadzanych przez użytkownika aplikacji. Do obsługi aplikacji storzony zostanie interfejs graficzny, który będzie posiadać intuicyjnie nazwaną funkcjonalność:  
-	Dodaj nowego pasażera  
-	Dodaj nowego pracownika - pilot, technik, asystent  
-	Rezerwacja biletu dla pasażera  
-	Zmiana klasy miejsca w samolocie  
Wszystkie informacje wyświetlane przez aplikację będą w języku angielskim.  
  
Projekt będzie wykonywany wykorzystaniem poniższych narzędzi:  
-	IntelliJ IDEA – wykorzystywane IDE  
-	Maven – dokładne wykrozystanie technologii zostanie uzupełnione po lepszym poznaniu technologi na wykładzie  
-	JDBC – do komunikacji z bazą danych  
-	JavaFX – do implementacji interfejsu graficznego  
-   SceneBuilder – narzędzie służące do łatwiejszej edycji i podglądu dokonanych zmian w plikach kontrolujących wygląd aplikacji
-	Do wykonania projektu nie mieliśmy potrzeby użycia plików JSON i CSV, wszystkie informacje o danych i odwoływanie się do nich udało się zrealizować za pomocą bazy danych lub kodu 
-	Klientem do bazy danych głównie był IntelliJ ze względu na bycie bardziej niezawodnym niż SQL Developer, choć i ten drugi był wykorzystany ze względu na jego popularność i naszą chęć nauki narzędzia
  
----------------------------------------------------------------------------------------------------------------------------------------------------
Instrukcja instalacji oprogramowania  
  
W celu uzyskania możliwości edycji kodu projektu należy zainstalować na swoim komputerze następujące oprogramowanie  
1)	Java: https://java.com/pl/download/manual.jsp  
2)	Java SDK: https://www.oracle.com/java/technologies/downloads/ 
3)	IDE – IntelliJ IDEA: https://www.jetbrains.com/idea/  
4)	OJDBC: https://www.oracle.com/database/technologies/appdev/jdbc-ucp-19c-downloads.html  
5)	Pobranie kodu z repozytoirum:  
`git pull https://gitlab-stud.elka.pw.edu.pl/mwasilew/pap21z-zxx.git`
  
----------------------------------------------------------------------------------------------------------------------------------------------------
Zdiagnozowane problemy i ich rozwiązania  
  
1)	Wysyłanie zmian do repozytorium z poziomu IntelliJ IDEA  
Jeśli w lokalnym peojekcie nie ma repozytorium:  
Z zakładki VSC należy wybrać:  
Create Git Repository > Ok  
Jeśli w katalogu roboczym jest już repozytorium, to z zakładki Git należy wybrać Branches  
i wybrać odpowiednią.  
Przyjętą konwencją jest dev_imie_klasa.  
Następnie z zakładki Git należy wybrać opcję Commit, a poźniej Push.  
Przy kontynuacji pracy opcją Update Project z zakładki Git można w łatwy sposób zaktualizować stan  
repozytorium lokalnego.  
  
2) Jeśli po pobraniu plików z repozytorium, kod z nieznanego powodu nie chce się kompilować albo nie jest właściwie wykrywany  
przez IntelliJ IDEA, należy utworzyć nowy, lokalny projekt i przkopiować do niego kod.  
Po wprowadzeniu założonych zmian w kodzie, należy utworzyć repozytoirum lokalne. Następnie zapiać wprowadzone zmiany i połączyć  
połączyć się ze zdalnym repozytoirum. Przed wysłaniem kodu do zdalnego repozytoirum należy zmienić nazwę gałęzi na nazwę zgodną  
z przyjętą konwecją.  
  
3) Jeśli po pobraniu kodu z repozytorium nie da się skompilować kodu skrótem klawiszowym Shift+F10 i nie pojawia  
się domyślna konfiguracja "Run'Main'", należy otworzyć klasę Main i naciśnąć prawym klawiszem myszy na wiersz  
"public static void main(String[] args) {" albo inny wiersz wskazywany przez zielone trójkąty przy numerach wierszy,  
a następnie wybrać opcję "Run 'Main'". Kod zostanie skompilowany a domyślna konfifuracja dodana do paska ze skrótami  
na górze edytora IntelliJ IDEA.  
  
4) Jeśli po pobraniu kodu z repozytorium aplikacja się nie włącza i pojawia się okienko z tytułem "Run/Debug Configurations" należy się upewnić,  
że w  sekcji "Build avd run" jest wybrana:  
- właściwa wersja Javy: "java 17 version 17"  
- właściwa klasa Main: "com.onibmagairlines.javafx.MainWindow"  

5) Jeżeli otwierając projekt w SceneBuilderze natkniemy się na błąd przy otwieraniu, należy upewnić się że zaimportowano odpowiednie pakiety, lub usunąć odpowiednie fragmenty kodu (lub zakomentować je) w odpowiednich plikach typu `.fxml`  
---------------------------------------------------------------------------------------------------------------------------------------------------- 
Wykorzytane w projekcie logo pochodzi ze strony, do której link zamieszczamy poniżej:  
https://www.vecteezy.com/?utm_source=vecteezy-download&utm_medium=license-info-pdf&utm_campaign=license-info-document
