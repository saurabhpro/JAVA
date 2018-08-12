package b_OpenClosedPrinciple;

import b_OpenClosedPrinciple.insurance_verifier.HealthInsuranceSurveyor;
import b_OpenClosedPrinciple.insurance_verifier.VehicleInsuranceSurveyor;
import org.junit.jupiter.api.Test;

class ClaimApprovalManagerTest {

    @Test
    void processClaim() {
        HealthInsuranceSurveyor healthInsuranceSurveyor = new HealthInsuranceSurveyor();
        ClaimApprovalManager claim1 = new ClaimApprovalManager();
        claim1.processClaim(healthInsuranceSurveyor);

        VehicleInsuranceSurveyor vehicleInsuranceSurveyor = new VehicleInsuranceSurveyor();
        ClaimApprovalManager claim2 = new ClaimApprovalManager();
        claim2.processClaim(vehicleInsuranceSurveyor);
    }

}