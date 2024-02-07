import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParallelTests {
//Comando ejecutor del pipeline en caso de publicación en ambientes devops
    //gradle test --tests ParallelTests -Dkarate.env=preproductive -Duser=karate -DbaseUrl=http://api.geonames.org/ -i
    @Test
    void testAll(){
        Results results = Runner.path("classpath:geonames").outputCucumberJson(true).tags("~@ignore").parallel(4);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());

    }

    public static void generateReport(String karateOuputPath){
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOuputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("build"), "prueba_tecnica_acme");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
