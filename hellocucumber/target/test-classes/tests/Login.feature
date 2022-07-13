Feature: Login

  Scenario: I test Login Standars
    Given Abro la pagina "https://www.saucedemo.com/"
    Given Me logeo con el usuario "standard_user" y la contraseña "secret_sauce"
    Then Verifico que el titulo sea "PRODUCTS"

  Scenario: I test Login Performance Glitch
    Given Abro la pagina "https://www.saucedemo.com/"
    Given Me logeo con el usuario "performance_glitch_user" y la contraseña "secret_sauce"
    Then Verifico que el titulo sea "PRODUCTS"