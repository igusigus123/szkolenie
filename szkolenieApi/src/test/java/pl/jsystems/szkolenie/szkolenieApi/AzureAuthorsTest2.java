package pl.jsystems.szkolenie.szkolenieApi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pl.jsystems.szkolenie.szkolenieApi.model.AzureUser;
import pl.jsystems.szkolenie.szkolenieApi.service.AzureServiceByPawel;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("API"), @Tag("Azure")})
@DisplayName("Azure authors test nottation2")
public class AzureAuthorsTest2 {

    @DisplayName("Get azure authors.")
    @Test
    public void azureAuthors() {

        //when
        List<AzureUser> azureAuthors = AzureServiceByPawel.getAzureAuthors();

        //then
        assertThat(azureAuthors.get(0).id).isEqualTo(1);
        assertThat(azureAuthors.get(0).id).isGreaterThan(0);
        assertThat(azureAuthors.get(0).firstName).isEqualTo("First Name " + azureAuthors.get(0).id);
        assertThat(azureAuthors.get(0).lastName).isEqualTo("Last Name " + azureAuthors.get(0).id);


        for (AzureUser azureAuthor : azureAuthors) {
            assertThat(azureAuthor.firstName).isEqualTo("First Name " + azureAuthor.id);
            assertThat(azureAuthor.lastName).isEqualTo("Last Name " + azureAuthor.id);
        }

    }
}
