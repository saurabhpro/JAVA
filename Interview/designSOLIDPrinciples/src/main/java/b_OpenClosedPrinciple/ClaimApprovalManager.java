package b_OpenClosedPrinciple;

import b_OpenClosedPrinciple.insurance_verifier.InsuranceSurveyor;

class ClaimApprovalManager {
	public void processClaim(InsuranceSurveyor surveyor) {
		if (surveyor.isValidClaim()) {
			System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
		}
	}
}