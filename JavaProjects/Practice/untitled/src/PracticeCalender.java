import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PracticeCalender {
    public static void main(String[] args) {
        // 可以添加日期
        // GregorianCalendar calendar = new GregorianCalendar(1991, 10, 1);
        GregorianCalendar calendar = new GregorianCalendar();
        int month = calendar.get(GregorianCalendar.MONTH) + 1;
        int year = calendar.get(GregorianCalendar.YEAR);

        System.out.println("Month is : " + month + " Year is : " + year);

        // 可以添加一年
        calendar.add(GregorianCalendar.YEAR, 1);
        month = calendar.get(GregorianCalendar.MONTH) + 1;
        year = calendar.get(GregorianCalendar.YEAR);
        System.out.println("Month is : " + month + " Year is : " + year);

        // 可以减一年
        calendar.add(GregorianCalendar.YEAR, -1); // 注意这里
        month = calendar.get(GregorianCalendar.MONTH) + 1;
        year = calendar.get(GregorianCalendar.YEAR);
        System.out.println("Month is : " + month + " Year is : " + year);

        /*
            Practice
            ============================
            使用 GregorianCalendar 构造一个
            星期日	星期一	星期二	星期三	星期四	星期五	星期六
                    1		2		3		4		5		6
            7		8		9		10		11		12		13
            14		15		16		17		18		19		20
            21		22		23		24#		25		26		27
            28		29		30		31
         */
        String[] weekNames = new DateFormatSymbols().getShortWeekdays();
        GregorianCalendar date = new GregorianCalendar();
        int today = date.get(Calendar.DAY_OF_MONTH);
        int _month = date.get(Calendar.MONTH);
        final String SYMBOL_TODAY = "#";

        // Print head of the week name;
        for (short i = 1; i < weekNames.length; ++i)
            System.out.print(weekNames[i] + "\t");
        System.out.println();

        // Back to first day of the month.
        date.set(Calendar.DAY_OF_MONTH, 1);

        // Print `indent`
        for (int i = 0; i < date.get(Calendar.DAY_OF_WEEK) - 1; i++)
            System.out.print("\t\t");

        while (date.get(Calendar.MONTH) == _month) {
            int logicToDay = date.get(Calendar.DAY_OF_MONTH);
            System.out.print(logicToDay + (logicToDay == today ? SYMBOL_TODAY : "") + "\t\t");
            date.add(Calendar.DAY_OF_MONTH, 1);

            if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                System.out.println();
        }
    }
}
