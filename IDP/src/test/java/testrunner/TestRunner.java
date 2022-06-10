package testrunner;

import java.util.List;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import stepdefinitions.SearchPageSteps;

public class TestRunner extends ConfigurableEmbedder {

	private Embedder embedder;

	@Override
	@Test
	public void run() {
		embedder = configuredEmbedder();
		embedder.configuration();
		embedder.runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/stories/*.story",
				"");
	}

	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
				.withFormats(org.jbehave.core.reporters.Format.CONSOLE, org.jbehave.core.reporters.Format.HTML));
	}

	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new SearchPageSteps());
	}
}