package zju.cst.aces;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import zju.cst.aces.api.Task;
import zju.cst.aces.api.impl.RunnerImpl;

import java.io.File;
import java.io.IOException;

@Mojo(name = "line")
public class LineTestMojo extends ProjectTestMojo {

    @Parameter(property = "selectMethod", required = true)
    public String selectMethod;

    @Parameter(property = "targetLine", required = true)
    public int line;

    public void execute() throws MojoExecutionException {
        init();
        if (shouldSkip()) return;

        String className = selectMethod.split("#")[0];
        String methodName = selectMethod.split("#")[1];

        try {
            if ("TELPA".equals(phaseType)) {
                File baseDir = project.getBasedir();
                log.info("TELPA mode: Executing Maven commands in the target project: "
                        + baseDir.getAbsolutePath());

                executeMavenCommand(baseDir, "clean");
                executeMavenCommand(baseDir, "compile");
                executeMavenCommand(baseDir, "install", "-DskipTests");
                executeMavenCommand(baseDir, "dependency:copy-dependencies");

                TelpaInit telpaInit = new TelpaInit();
                telpaInit.generateSmartUnitTest(project, smartUnitTest_path, config);
            }

            new Task(config, new RunnerImpl(config))
                    .startLineTask(className, methodName, line);

        } catch (Exception e) {
            throw new MojoExecutionException(
                    "Failed to generate tests for line: "
                            + selectMethod + ":" + line, e
            );
        }
    }
}
