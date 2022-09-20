package SpringApp_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public String string;

    public static void main(String[] args) {
        /*
        Класс ClassPathXmlApplicationContext обращается к applicationContext.xml (который должен находится в дирректории
        с маркировкой Test Resources Root), считывает все Bean и передает их в Application Context
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        /*
        Метод getBean() возвращает Bean и принимет в качестве аргументов Bean id из applicationContext.xml и
        предполагаемый class Bean
         */

        /*
        "Ручное" внедрение зависимости через создание объекта оператором new
        ===============Использование паттерна IoC - Inversion of Control===============
        Music music = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        */

        /*
        "Автоматическое" внедрение зависимостей через applicationContext.xml
        ===============использование паттерна DI - Dependency Injection===============
        По умолчанию scope Bean - Singleton, т.е. при вызове метода getBean() создается 1 Bean
        scope Prototype позволяет получать новый Bean каждый раз при вызове метода getBean()

        Методы init-method и destroy-method вызываются неявно каждый раз при инициализации и уничтожении Bean
        В этих методах мы можем явно прописать логику и указать в applicationContext.xml ссылки на них
        Метод destroy-method не вызывается для Bean со scope Prototype, т.к. Spring не берет на себя полный жизненный
        цикл Bean с этим scope, а передает их клиенту после создания

        Метод factory-method явно указывает способ создания Bean, он должен быть static,т.к. должен вызываться не у
        объекта, а у класса (иначе для создания объекта требовался бы вызов метода factory, который должен создавать
        данный объект)
        Для scope Singleton при использовании factory-method все равно создается только 1 Bean, т.к. данный метод
        вызывается только 1 раз для Singleton, а для последующих попыток просто ссылается на уже существующий Bean
        */

        ClassicalMusic classicalMusic = context.getBean("musicBeanClassical", ClassicalMusic.class);
        ;
        System.out.println(classicalMusic.getSong());

        /*MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer == secondMusicPlayer);*/

        //musicPlayer.playMusic();

        context.close();
    }
}
