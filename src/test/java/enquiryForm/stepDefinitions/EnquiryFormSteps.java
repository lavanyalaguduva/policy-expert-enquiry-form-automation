package enquiryForm.stepDefinitions;

import enquiryForm.actions.FillEnquiryForm;
import enquiryForm.navigation.EnquiryDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class EnquiryFormSteps {
    EnquiryDetailsPage detailsPage;

    @Given("Sergey is enquire form page")
    public void sergeyIsEnquireFormPage() {
        detailsPage.open();
    }

    @When("I fill the details in {string} section")
    public void iFillTheDetailsInSection(String sectionName) {
        String sectionKey = getSectionKey(sectionName);
        FillEnquiryForm enquiryForm = new FillEnquiryForm();
        enquiryForm.fillSection(detailsPage, sectionKey);
    }

    private String getSectionKey(String sectionName) {
        return sectionName.toLowerCase();

    }

}
