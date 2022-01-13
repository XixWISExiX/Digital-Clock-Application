import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.Color;

//Makes the interface for the application.
public class MyFrame extends JFrame
{

  //Names the format, label, and string for the time, day and date.
  SimpleDateFormat timeFormat;
  SimpleDateFormat dayFormat;
  SimpleDateFormat dateFormat;

  JLabel timeLabel;
  JLabel dayLabel;
  JLabel dateLabel;

  String time;
  String day;
  String date;

  MyFrame()
  {
    //Allows the application to close.
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Names the application.
    this.setTitle("Digital Clock Application");
    //Allows the text in the application to change baised on the size or situation of the application.
    this.setLayout(new FlowLayout());
    //Sets the size for the application.
    this.setSize(350,200);

    //Setting the format for the time, day, and date.
    timeFormat = new SimpleDateFormat("hh:mm:ss a");
    dayFormat = new SimpleDateFormat("EEEE");
    dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

    timeLabel = new JLabel();
    //Changing how the text looks for the time, day, and date labels.
    timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
    timeLabel.setForeground(new Color(0x00FF00));
    timeLabel.setBackground(Color.black);
    timeLabel.setOpaque(true);

    dayLabel = new JLabel();
    dayLabel.setFont(new Font("Sans Serif",Font.PLAIN,35));

    dateLabel = new JLabel();
    dateLabel.setFont(new Font("Sans Serif",Font.PLAIN,25));

    //Allows the labels to be displayed to the user.
    this.add(timeLabel);
    this.add(dayLabel);
    this.add(dateLabel);
    this.setVisible(true);

    setTime();

  }

  public void setTime()
  {
    //Updates the time, day, and date every second to the user.
    while(true)
    {
      time = timeFormat.format(Calendar.getInstance().getTime());
      timeLabel.setText(time);

      day = dayFormat.format(Calendar.getInstance().getTime());
      dayLabel.setText(day);

      date = dateFormat.format(Calendar.getInstance().getTime());
      dateLabel.setText(date);

      try{Thread.sleep(1000);}
      catch(InterruptedException e){ e.printStackTrace();}
    }
  }

}
