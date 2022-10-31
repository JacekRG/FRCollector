# Testy jednostkowe
- *Data* 2022-10-30<br>
- *Status:* Zaproponowany<br>
- *Kontekst:* Potrzebujemy biblioteki do przygotowania testów jednostkowych.<br>
Rozwiązanie powinno dobrze integrować się z Java 17 oraz być wspierane przez Intellij Idea.<br>
- *Rozwiązania:*<br>
    - Opcja 1: AssertJ<br>
    - Opcja 2: Hamcrest<br>
- *Decyzja:*<br>
Obie biblioteki są szeroko stosowane, opracowane przez aktywne społeczności i zapewniają podobną wydajność.<br>
Ze względu na większe doświadczenie zespołu z AssertJ - to właśnie on będzie łatwiejszy w adaptacji.<br>
- *Konsekwencje:*<br>
Projekt 100 ideas wykorzysta AssertJ do przygotowania testów jednostkowych.<br>
