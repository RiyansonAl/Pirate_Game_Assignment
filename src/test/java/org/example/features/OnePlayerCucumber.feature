Feature: Tests for One player and check score

  Scenario: Die with 3 skulls
    Given that the host is initialized
    When I roll "Skull, Skull, Skull, Sword, Sword, Sword, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    Then I die and get a score of 0

    Scenario:Acceptance Test Line 38
      Given that the host is initialized
      When I roll "Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword, Sword"
      And  I draw a "Gold" card
      And Player 1 starts there turn
      And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Sword"
      Then I die and get a score of 0

  Scenario:Acceptance Test Line 39
    Given that the host is initialized
    When I roll "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Skull, Parrot, Parrot, Parrot, Parrot, Skull, Sword"
    Then I die and get a score of 0

  Scenario:Acceptance Test Line 40
    Given that the host is initialized
    When I roll "Skull, Parrot, Parrot, Parrot, Sword, Parrot, Sword, Sword"
    And  I draw a "Gold" card
    And Player 1 starts there turn
    And Player 1 keeps dice "1,2,3,4,5" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Monkey, Monkey"
    And Player 1 keeps dice "1,2,3,4,5,6" and re-rolls the rest and gets "Skull, Parrot, Parrot, Parrot, Parrot, Skull, Skull, Monkey"
    Then I die and get a score of 0