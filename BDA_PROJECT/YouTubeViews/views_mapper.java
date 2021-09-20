package bda_project_topviews;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class views_mapper extends Mapper<LongWritable, Text, Text,
IntWritable> {

       private Text video_name = new Text();
       private  IntWritable views = new IntWritable();
       public void map(LongWritable key, Text value, Context context )
throws IOException, InterruptedException {
           String line = value.toString();
           String str[]=line.split(",");

          if(str.length >= 5){
                video_name.set(str[0]);
                str[5]=str[5].replace("\"", "");
                if(str[5].matches("\\d+")){ //this regular expression	specifies that the string should contain only integer values
                	int temp=Integer.parseInt(str[5]); //typecasting string to Integer
                	views.set(temp);
                }
          }

      context.write(video_name, views);
      }

    }