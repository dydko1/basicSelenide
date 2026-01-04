Tutorial.: z chatgpt w archiwum "Tutoriale Selenide online"

1) Jeden test (klasa), 1 przeglądarka, sekwencyjnie
mvn test -Dtest=DynamicControls008Test `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=1" `
  "-Djunit.jupiter.execution.parallel.mode.default=same_thread" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=same_thread"

2) Jeden test (klasa), N przeglądarek (równolegle w obrębie wybranych testów)
mvn test -Dtest=DynamicControls008Test `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=4" `
  "-Djunit.jupiter.execution.parallel.mode.default=concurrent" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=concurrent"

3) Wszystkie testy (lokalnie), 1 przeglądarka, sekwencyjnie
mvn test `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=1" `
  "-Djunit.jupiter.execution.parallel.mode.default=same_thread" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=same_thread"

4) Wszystkie testy (CI), N przeglądarek równolegle
mvn test `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=8" `
  "-Djunit.jupiter.execution.parallel.mode.default=concurrent" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=concurrent"


Jeśli chcesz też wariant jednej metody testowej (np. ClassName#methodName) — dopiszę jako 5. komendę.

tak
Myślał przez kilka sekund
5) Jedna metoda testowa (dokładnie 1 test), 1 przeglądarka, sekwencyjnie

Podmień #NAZWA_METODY na nazwę metody testowej.

mvn test -Dtest=DynamicControls008Test#NAZWA_METODY `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=1" `
  "-Djunit.jupiter.execution.parallel.mode.default=same_thread" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=same_thread"

6) Jedna metoda testowa, N przeglądarek (jeśli odpalisz więcej metod/klas w filtrze)
mvn test -Dtest=DynamicControls008Test#NAZWA_METODY `
  "-Djunit.jupiter.execution.parallel.config.fixed.parallelism=4" `
  "-Djunit.jupiter.execution.parallel.mode.default=concurrent" `
  "-Djunit.jupiter.execution.parallel.mode.classes.default=concurrent"


Uwaga praktyczna: filtr -Dtest=Class#method i tak uruchamia jedną metodę, więc równoległość realnie ma sens dopiero, gdy uruchamiasz więcej niż jeden test (np. kilka klas albo wiele metod).