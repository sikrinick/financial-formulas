import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SimpleFutureValueTest::class,
    CompoundingFutureValueTest::class)
class AllTests