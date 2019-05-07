package com.natalia.fatherdmitrymanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class VariantsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "father_dmitry.db";
    private static final int DATABASE_VERSION = 21;

    public VariantsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        createDatabase(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + VariantsContracts.VariantsEntry.TABLE_VARIANTS);
        sqLiteDatabase.execSQL("DROP TABLE " + QuestionsContracts.QuestionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS);

        createDatabase(sqLiteDatabase);
    }

    private void createDatabase(SQLiteDatabase sqLiteDatabase) {
        String sSql = "CREATE TABLE IF NOT EXISTS " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " ("
                + VariantsContracts.VariantsEntry._ID + " STRING PRIMARY KEY,"
                + VariantsContracts.VariantsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL,"
                + VariantsContracts.VariantsEntry.COLUMN_SOFA_POINTS + " INTEGER NOT NULL,"
                + VariantsContracts.VariantsEntry.COLUMN_GIRL_POINTS + " INTEGER NOT NULL,"
                + VariantsContracts.VariantsEntry.COLUMN_WORK_POINTS + " INTEGER NOT NULL"
                + ")";


        sqLiteDatabase.execSQL(sSql);

        sSql = "CREATE TABLE IF NOT EXISTS " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " ("
                + QuestionsContracts.QuestionsEntry._ID + " STRING PRIMARY KEY,"
                + QuestionsContracts.QuestionsEntry.COLUMN_DESCRIPTION + " STRING"
                + ")";

        sqLiteDatabase.execSQL(sSql);


        sSql = "CREATE TABLE IF NOT EXISTS " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " ("
                + QuestionsVariantsContracts.QuestionsVariantsEntry.COLUMN_QUESTION + " STRING,"
                + QuestionsVariantsContracts.QuestionsVariantsEntry.COLUMN_VARIANT + " STRING"
                + ")";

        sqLiteDatabase.execSQL(sSql);

        sSql = "CREATE TABLE IF NOT EXISTS " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " ("
                + VariantsAssociationsContracts.VariantsAssociatiosEntry.COLUMN_VARIANT_FROM + " STRING,"
                + VariantsAssociationsContracts.VariantsAssociatiosEntry.COLUMN_VARIANT_TO + " STRING"
                + ")";

        sqLiteDatabase.execSQL(sSql);

        fillQuestions(sqLiteDatabase);

        fillVariants(sqLiteDatabase);

        fillMoves(sqLiteDatabase);

        fillQuestionVariants(sqLiteDatabase);
    }


    private void fillQuestions(SQLiteDatabase sqLiteDatabase) {

        // ВОПРОСЫ

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'question1', "
                + "'Привет, Дмитрий! Твое счастье уже совсем близко. Осталось только решить пару вопросов... Во-первых, как отметишь свой День Рождения?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'championship', "
                + "'Тебя послали участвовать в чемпионате мира по тимлидингу. Как будешь готовиться?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'popularity', "
                + "'Ты выиграл чемпионат мира и стал очень популярным. Тебя узнают на улицах, не дают прохода фанатки.'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'girl_tuam', "
                + "'Твоя девушка сообщила тебе, что уезжает в Тюм (навсегда). Что будешь делать?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'team_tuam', "
                + "'Твоя команда тоже переехала в Тюм, чтобы поддержать тебя.'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'mafia', "
                + "'В Тюм потянулись ваши родственники и друзья, а потом друзья друзей. Тебе предлагают стать Крестным Отцом. Что скажешь?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'crimea', "
                + "'Ты очнулся на пляже в Крыму. Что будешь делать?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'nikita_leave', "
                + "'Никита сообщил, что женится на ирландке и уходит из Люксофта. Твои действия?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'fire_somebody', "
                + "'Женя сказал, что нужно уволить кого-то из твоей команды. Кого выберешь?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'ard_ri', "
                + "'В Ard Ri перестали давать омлет на завтрак. Что будешь есть?'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsContracts.QuestionsEntry.TABLE_NAME + " values ("
                + "'lottery', "
                + "'Ты выиграл в лотерею миллион долларов. На что потратишь?'"
                + ")"
        );
    }

    private void fillVariants(SQLiteDatabase sqLiteDatabase) {
        // ОТВЕТЫ

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'colleagues_birthday_party', "
                + "'С любимыми коллегами',"
                + "5,"
                + "0,"
                + "10"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'night_birthday_party', "
                + "'Буду тусить всю ночь с друзьями',"
                + "-5,"
                + "5,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'girl_birthday_party', "
                + "'С девушкой',"
                + "5,"
                + "10,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'old', "
                + "'Я слишком стар',"
                + "5,"
                + "10,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'buy_swim_suit', "
                + "'Пойду покупать плавки для конкурса в купальниках',"
                + "0,"
                + "10,"
                + "10"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'training', "
                + "'Разработаю план тренировок и сделаю все, чтобы выиграть',"
                + "0,"
                + "-5,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'enjoy_popularity', "
                + "'Купаюсь в лучах славы',"
                + "-5,"
                + "5,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'change_appearance', "
                + "'Сделаю операцию по изменению внешности',"
                + "0,"
                + "10,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'go_tuam', "
                + "'Поеду за ней как муж декабристки',"
                + "10,"
                + "10,"
                + "-5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'stay_spb', "
                + "'Завернусь в рулетик, буду плакать, но останусь в Петербурге',"
                + "5,"
                + "-10,"
                + "5"
                + ")"
        );
        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'enjoy_team_tuam', "
                + "'Радуюсь',"
                + "0,"
                + "0,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'fire_all_stupid', "
                + "'Уволю всех и наберу новых, зачем такие неумные люди',"
                + "0,"
                + "0,"
                + "-200"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'god_father', "
                + "'Соглашусь',"
                + "100,"
                + "-200,"
                + "100"
                + ")"
        );
        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'refuse_god_father', "
                + "'У меня недостаточно квалификации, чтобы быть Крестным Отцом',"
                + "0,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'father_dmitry', "
                + "'Создам Церковь Отца Дмитрия и буду проповедовать',"
                + "40,"
                + "5,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'two_weeks_vacation', "
                + "'Отдохну пару недель и поеду домой',"
                + "10,"
                + "10,"
                + "10"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'go_home_immediately', "
                + "'Как можно скорее поеду домой, работы ведь невпроворот',"
                + "0,"
                + "5,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'steal_nikita_girl', "
                + "'Использую свои чары и отобью у него невесту.',"
                + "0,"
                + "10,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'bless_nikita', "
                + "'Благословлю его выбор',"
                + "0,"
                + "0,"
                + "-5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'fire_pasha', "
                + "'Пашу',"
                + "0,"
                + "5,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'fire_nikita', "
                + "'Никиту',"
                + "5,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'fire_natasha', "
                + "'Наташу',"
                + "0,"
                + "0,"
                + "5"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'fire_all', "
                + "'Уволю всех, чтобы никому не было обидно',"
                + "0,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'full_irish', "
                + "'Full Irish Breakfast',"
                + "0,"
                + "10,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'poached_eggs', "
                + "'Poached eggs with bacon',"
                + "0,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'scrambled_eggs', "
                + "'Scrambled eggs with salmon',"
                + "0,"
                + "0,"
                + "10"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'buy_apartment', "
                + "'Куплю еще одну квартиру',"
                + "10,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'buy_stocks', "
                + "'Вложу деньги в акции',"
                + "-100,"
                + "0,"
                + "0"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsContracts.VariantsEntry.TABLE_VARIANTS + " values ("
                + "'buy_sofa', "
                + "'Куплю самый крутой в мире диван',"
                + "10,"
                + "0,"
                + "0"
                + ")"
        );
    }

    private void fillQuestionVariants(SQLiteDatabase sqLiteDatabase) {

        // ВОПРОС - ВАРИАНТЫ

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'question1', "
                + "'colleagues_birthday_party'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'question1', "
                + "'night_birthday_party'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'question1', "
                + "'girl_birthday_party'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'question1', "
                + "'old_birthday_party'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'championship', "
                + "'buy_swim_suit'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'championship', "
                + "'training'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'championship', "
                + "'old'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'popularity', "
                + "'enjoy_popularity'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'popularity', "
                + "'change_appearance'"
                + ")"
        );
        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'girl_tuam', "
                + "'go_tuam'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'girl_tuam', "
                + "'stay_spb'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'team_tuam', "
                + "'enjoy_team_tuam'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'team_tuam', "
                + "'fire_all_stupid'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'mafia', "
                + "'god_father'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'mafia', "
                + "'refuse_god_father'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'crimea', "
                + "'two_weeks_vacation'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'crimea', "
                + "'go_home_immediately'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'nikita_leave', "
                + "'steal_nikita_girl'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'nikita_leave', "
                + "'bless_nikita'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'fire_somebody', "
                + "'fire_pasha'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'fire_somebody', "
                + "'fire_nikita'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'fire_somebody', "
                + "'fire_natasha'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'fire_somebody', "
                + "'fire_all'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'ard_ri', "
                + "'poached_eggs'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'ard_ri', "
                + "'full_irish'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'ard_ri', "
                + "'scrambled_eggs'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'lottery', "
                + "'buy_apartment'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'lottery', "
                + "'father_dmitry'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'lottery', "
                + "'buy_stocks'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME + " values ("
                + "'lottery', "
                + "'buy_sofa'"
                + ")"
        );
    }

    private void fillMoves(SQLiteDatabase sqLiteDatabase) {

        // ПЕРЕХОД К СЛЕДУЮЩЕМУ ВОПРОСУ

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'', "
                + "'question1'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'colleagues_birthday_party',"
                + "'championship'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'buy_swim_suit', "
                + "'popularity'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'training', "
                + "'popularity'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'enjoy_popularity', "
                + "'girl_tuam'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'go_tuam', "
                + "'team_tuam'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'enjoy_team_tuam', "
                + "'mafia'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'refuse_god_father', "
                + "'crimea'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'two_weeks_vacation', "
                + "'nikita_leave'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'go_home_immediately', "
                + "'fire_somebody'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'steal_nikita_girl', "
                + "'ard_ri'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'full_irish', "
                + "'lottery'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'poached_eggs', "
                + "'lottery'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'scrambled_eggs', "
                + "'lottery'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'girl_birthday_party', "
                + "'girl_tuam'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'night_birthday_party', "
                + "'crimea'"
                + ")"
        );

        sqLiteDatabase.execSQL("insert into " + VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS + " values ("
                + "'change_appearance', "
                + "'crimea'"
                + ")"
        );
    }
}
