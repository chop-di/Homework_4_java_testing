# Homework_4_java_testing
POM & Page Factory

----------Page Factory-------------------
В папке src/main/java/PageFactory находится встроенная концепция объектной модели страницы для Selenium WebDriver, но она очень оптимизирована.
Здесь мы также следуем концепции разделения хранилища объектов страниц и методов тестирования. Кроме того, с помощью класса PageFactory мы используем аннотации @FindBy для поиска WebElement. Мы используем метод initElements для инициализации веб-элементов
Объектная модель страницы (POM) и фабрика страниц в Selenium: полное руководство
@FindBy может принимать в качестве атрибутов tagName ,partalLinkText, name, linkText, id, css, className, xpath .

--------------POM--------------

в папке src/main/pages и /test находятся классы Guru Login и GuruHome
