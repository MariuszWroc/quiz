/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

/**
 *
 * @author Mariusz Czarny
 */
public final class SampleData {
    public final static String[] QUESTION;
    public final static String[] ANSWER;
    public final static String[] USER_FIRSTNAME;
    public final static String[] USER_SECONDNAME;    
    public final static String SAMPLE_EMAIL = "sample@email.com";
    public final static String SAMPLE_JOB_FAIR = "Jakies targi ";
    
    static {
        QUESTION = new String[10];
        QUESTION[0] = "Pytanie 1";
        QUESTION[1] = "Pytanie 2";
        QUESTION[2] = "Pytanie 3";
        QUESTION[3] = "Pytanie 4";
        QUESTION[4] = "Pytanie 5";
        QUESTION[5] = "Pytanie 6";
        QUESTION[6] = "Pytanie 7";
        QUESTION[7] = "Pytanie 8";
        QUESTION[8] = "Pytanie 9";
        QUESTION[9] = "Pytanie 10";

        ANSWER = new String[10];
        ANSWER[0] = "Odpowiedź 1";
        ANSWER[1] = "Odpowiedź 2";
        ANSWER[2] = "Odpowiedź 3";
        ANSWER[3] = "Odpowiedź 4";
        ANSWER[4] = "Odpowiedź 5";
        ANSWER[5] = "Odpowiedź 6";
        ANSWER[6] = "Odpowiedź 7";
        ANSWER[7] = "Odpowiedź 8";
        ANSWER[8] = "Odpowiedź 9";
        ANSWER[9] = "Odpowiedź 10";

        USER_FIRSTNAME = new String[10];
        USER_FIRSTNAME[0] = "Sebastian";
        USER_FIRSTNAME[1] = "Waldemar";
        USER_FIRSTNAME[2] = "Tadeusz";
        USER_FIRSTNAME[3] = "Miroslaw";
        USER_FIRSTNAME[4] = "Mariusz";
        USER_FIRSTNAME[5] = "Krzysztof";
        USER_FIRSTNAME[6] = "Tomasz";
        USER_FIRSTNAME[7] = "Rafal";
        USER_FIRSTNAME[8] = "Antoni";
        USER_FIRSTNAME[9] = "Pawel";

        USER_SECONDNAME = new String[10];
        USER_SECONDNAME[0] = "Socha";
        USER_SECONDNAME[1] = "Mila";
        USER_SECONDNAME[2] = "Gikiewicz";
        USER_SECONDNAME[3] = "Sobota";
        USER_SECONDNAME[4] = "Zielinski";
        USER_SECONDNAME[5] = "Hajto";
        USER_SECONDNAME[6] = "Waldoch";
        USER_SECONDNAME[7] = "Kokoszka";
        USER_SECONDNAME[8] = "Lewandowski";
        USER_SECONDNAME[9] = "Sobiech";
    }
}
