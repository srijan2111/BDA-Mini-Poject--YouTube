package bda_project_youtubeuploader;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public  class uploader_reducer extends Reducer<Text,IntWritable,Text,IntWritable>{

	public void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException,InterruptedException {
		int totaloccurance = 0;

		for(IntWritable value: values)
		{
			totaloccurance+=value.get();
		}
		context.write(key, new IntWritable(totaloccurance));
		
	}
	
}