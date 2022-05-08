package ru.cchgeu.electronicassistantbackend.model.entity.security;

public enum Permission {
    CONFIRMATION_OF_STATEMENTS_AND_DIRECTIONS, //Подтверждение ведомостей и направлений
    ISSUANCE_OF_CERTIFICATES_AND_DIRECTIONS, //Выдача справок и направлений
    CREATING_EVENTS, //Создание мероприятий
    CREATING_VACANCIES, //Создание вакансий
    CREATING_SURVEYS, //Создание опросов
    VIEWING_EVENT_RESULTS, //Просмотр результатов мероприятий
    VIEWING_SURVEY_RESULTS //Просмотр результатов опросов
}
