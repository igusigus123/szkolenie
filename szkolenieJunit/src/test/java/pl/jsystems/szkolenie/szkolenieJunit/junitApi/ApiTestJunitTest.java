package pl.jsystems.szkolenie.szkolenieJunit.junitApi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.jsystems.szkolenie.szkolenieJunit.ConfigJunit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTestJunitTest extends ConfigJunit {
        @Test
        public void sampleApiTEst() {
            assertTrue(true);
        }
    }

