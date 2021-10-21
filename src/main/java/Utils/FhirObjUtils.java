package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.AddressUse;
import com.ibm.fhir.model.type.code.AdministrativeGender;
import com.ibm.fhir.model.type.code.ContactPointSystem;
import com.ibm.fhir.model.type.code.ContactPointUse;
import com.ibm.fhir.model.type.code.EncounterLocationStatus;
import com.ibm.fhir.model.type.code.EncounterStatus;
import com.ibm.fhir.model.type.code.IdentifierUse;
import com.ibm.fhir.model.type.code.ImmunizationStatus;
import com.ibm.fhir.model.type.code.MedicationStatus;
import com.ibm.fhir.model.type.code.NameUse;
import com.ibm.fhir.model.type.code.ObservationStatus;

public class FhirObjUtils {
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+08:00");
	
	public Period setPeriod(Date start, Date end) {
		com.ibm.fhir.model.type.Period.Builder periodBuilder = Period.builder();
		if (start != null) {
			periodBuilder.start(DateTime.of(sdf.format(start)));
		}
		
		if (end != null) {
			periodBuilder.end(DateTime.of(sdf.format(end)));
		}
		
		return periodBuilder.build();
	}
	
	public Period setPeriod(Date start, Date end, SimpleDateFormat simpleDateFormat) {
		com.ibm.fhir.model.type.Period.Builder periodBuilder = Period.builder();
		if (start != null) {
			periodBuilder.start(DateTime.of(simpleDateFormat.format(start)));
		}
		
		if (end != null) {
			periodBuilder.end(DateTime.of(simpleDateFormat.format(end)));
		}
		
		return periodBuilder.build();
	}

	public HumanName setHumanName(java.lang.String use, java.lang.String text, java.lang.String family, 
			java.lang.String given, java.lang.String prefix, java.lang.String suffix, Date PeriodStart, Date PeriodEnd) {
		com.ibm.fhir.model.type.HumanName.Builder humanNameBuilder = HumanName.builder();
		
		if (use != null) {
			humanNameBuilder.use(this.mapHumanNameUse(use));
		}
		
		if (text != null) {
			humanNameBuilder.text(String.of(text));
		}
		
		if (family != null) {
			humanNameBuilder.family(String.of(family));
		}
		
		if (given != null) {
			humanNameBuilder.given(String.of(given));
		}
		
		if (prefix != null) {
			humanNameBuilder.prefix(String.of(prefix));
		}
		
		if (suffix != null) {
			humanNameBuilder.suffix(String.of(suffix));
		}
		
		if (PeriodStart != null && PeriodEnd != null) {
			humanNameBuilder.period(this.setPeriod(PeriodStart, PeriodEnd));
		}
		
		return humanNameBuilder.build();
	}
	
	public DateTime setDateTime (Date date) {
		if (date == null) {
			return null;
		}
		
		return DateTime.builder().value(this.sdf.format(date)).build();
	}
	
	public DateTime setDateTime (Date date, SimpleDateFormat simpleDateFormat) {
		if (date == null) {
			return null;
		}
		
		return DateTime.builder().value(simpleDateFormat.format(date)).build();
	}
	
	public Reference setReference(java.lang.String reference, java.lang.String type, Identifier identifier, java.lang.String display) {
		com.ibm.fhir.model.type.Reference.Builder referenceBuilder = Reference.builder();
		if (reference != null) {
			referenceBuilder.reference(String.of(reference));
		}
		
		if (type != null) {
			referenceBuilder.type(Uri.of(type));
		}
		
		if (identifier != null) {
			referenceBuilder.identifier(identifier);
		}
		
		if (display != null) {
			referenceBuilder.display(String.of(display));
		}
		
		return referenceBuilder.build();
	}
	
	public CodeableConcept setCodeableConcept(Coding coding, java.lang.String text) {
		com.ibm.fhir.model.type.CodeableConcept.Builder condeableConceptBuilder = CodeableConcept.builder();
		
		if (coding != null) {
			condeableConceptBuilder.coding(coding);
		}
		
		if (text != null) {
			condeableConceptBuilder.text(String.of(text));
		}
		
		return condeableConceptBuilder.build();
	}
	
	public CodeableConcept setCodeableConcept(List<Coding> codingList, java.lang.String text) {
		com.ibm.fhir.model.type.CodeableConcept.Builder condeableConceptBuilder = CodeableConcept.builder();
		
		if (codingList != null && codingList.size() > 0) {
			condeableConceptBuilder.coding(codingList);
		}
		
		if (text != null) {
			condeableConceptBuilder.text(String.of(text));
		}
		
		return condeableConceptBuilder.build();
	}
	
	public CodeableConcept setCodeableConcept(java.lang.String system, java.lang.String code, java.lang.String display) {
		return this.setCodeableConcept(system, null, code, display, null, null);
	}
	
	public CodeableConcept setCodeableConcept(java.lang.String system, java.lang.String version, java.lang.String code, java.lang.String display, java.lang.Boolean useSelected, java.lang.String text) {
		Coding coding = this.setCoding(system, version, code, display, useSelected);
		return this.setCodeableConcept(coding, text);
	}
	
	public Coding setCoding(java.lang.String system, java.lang.String code, java.lang.String display) {
		return this.setCoding(system, null, code, display, null);
	}
	
	public Coding setCoding(java.lang.String system, java.lang.String version, java.lang.String code, java.lang.String display, java.lang.Boolean useSelected) {
		com.ibm.fhir.model.type.Coding.Builder codingBuilder = Coding.builder();
		
		if (system != null) {
			codingBuilder.system(Uri.of(system));
		}
		
		if (code != null) {
			codingBuilder.code(Code.of(code));
		}
		
		if (version != null) {
			codingBuilder.version(String.of(version));
		}
		
		if (display != null) {
			codingBuilder.display(String.of(display));
		}
		
		if (useSelected != null) {
			codingBuilder.userSelected(Boolean.of(useSelected));
		}
		
		return codingBuilder.build();
	}
	
	public EncounterLocationStatus mapLocationStatus (java.lang.String status) {
		if(status == null || status.length() == 0) {
			return null;
		}
		status = status.toUpperCase();
		
		if (status.equals("ACTIVE")) {
			return EncounterLocationStatus.ACTIVE;
		} else if (status.equals("RESERVED")) {
			return EncounterLocationStatus.RESERVED;
		} else if (status.equals("PLANNED")) {
			return EncounterLocationStatus.PLANNED;
		} else if (status.equals("COMPLETED")) {
			return EncounterLocationStatus.COMPLETED;
		}
		
		throw new IllegalStateException("cannot find the EncounterLocationStatus: " + status);
	}
	
	public EncounterStatus mapEncounterStatus (java.lang.String status) {
		if(status == null || status.length() == 0) {
			return null;
		}
		
		status = status.toUpperCase();
		
		if (status.equals("IN-PROGRESS")) {
			return EncounterStatus.IN_PROGRESS;
		} else if (status.equals("PLANNED")) {
			return EncounterStatus.PLANNED;
		} else if (status.equals("ARRIVED")) {
			return EncounterStatus.ARRIVED;
		} else if (status.equals("TRIAGED")) {
			return EncounterStatus.TRIAGED;
		} else if (status.equals("ONLEAVE")) {
			return EncounterStatus.ONLEAVE;
		} else if (status.equals("FINISHED")) {
			return EncounterStatus.FINISHED;
		} else if (status.equals("CANCELLED")) {
			return EncounterStatus.CANCELLED;
		} else if (status.equals("UNKNOWN")) {
			return EncounterStatus.UNKNOWN;
		} else if (status.equals("ENTERED-IN-ERROR")) {
			return EncounterStatus.ENTERED_IN_ERROR;
		} 
		
		throw new IllegalStateException("cannot find the EncounterStatus: " + status);
	}
	
	public ImmunizationStatus mapImmunizationStatus (java.lang.String status) {
		if(status == null || status.length() == 0) {
			return null;
		}
		status = status.toUpperCase();
		
		if (status.equals("COMPLETED")) {
			return ImmunizationStatus.COMPLETED;
		} else if (status.equals("ENTERED-IN-ERROR")) {
			return ImmunizationStatus.ENTERED_IN_ERROR;
		} else if (status.equals("NOT-DONE")) {
			return ImmunizationStatus.NOT_DONE;
		} 
		
		throw new IllegalStateException("cannot find the ImmunizationStatus: " + status);
	} 
	
	public MedicationStatus mapMedicationStatus (java.lang.String status) {
		if(status == null || status.length() == 0) {
			return null;
		}
		status = status.toUpperCase();
		
		if (status.equals("ACTIVE")) {
			return MedicationStatus.ACTIVE;
		} else if (status.equals("INACTIVE")) {
			return MedicationStatus.INACTIVE;
		} else if (status.equals("ENTERED_IN_ERROR")) {
			return MedicationStatus.ENTERED_IN_ERROR;
		} 
		
		throw new IllegalStateException("cannot find the MedicationStatus: " + status);
	} 
	
	public ObservationStatus mapObservationStatus (java.lang.String status) {
		if(status == null || status.length() == 0) {
			return null;
		}
		status = status.toUpperCase();
		
		if (status.equals("AMENDED")) {
			return ObservationStatus.AMENDED;
		} else if (status.equals("CANCELLED")) {
			return ObservationStatus.CANCELLED;
		} else if (status.equals("CORRECTED")) {
			return ObservationStatus.CORRECTED;
		} else if (status.equals("ENTERED IN ERROR")) {
			return ObservationStatus.ENTERED_IN_ERROR;
		} else if (status.equals("FINAL")) {
			return ObservationStatus.FINAL;
		} else if (status.equals("PRELIMINARY")) {
			return ObservationStatus.PRELIMINARY;
		} else if (status.equals("REGISTERED")) {
			return ObservationStatus.REGISTERED;
		} else if (status.equals("UNKNOWN")) {
			return ObservationStatus.UNKNOWN;
		} 
		
		throw new IllegalStateException("cannot find the ObservationStatus: " + status);
	}
	
	public ContactPointSystem mapTelcomType (java.lang.String telcomType) {
		if(telcomType == null || telcomType.length() == 0) {
			return null;
		}
		telcomType = telcomType.toUpperCase();
		
		if (telcomType.equals("PHONE")) {
			return ContactPointSystem.PHONE;
		} else if (telcomType.equals("EMAIL")) {
			return ContactPointSystem.EMAIL;
		} else if (telcomType.equals("FAX")) {
			return ContactPointSystem.FAX;
		} else if (telcomType.equals("FAX")) {
			return ContactPointSystem.PAGER;
		} else if (telcomType.equals("URL")) {
			return ContactPointSystem.URL;
		} else if (telcomType.equals("SMS")) {
			return ContactPointSystem.SMS;
		} 

		throw new IllegalStateException("cannot find the ContactPointSystem:" + telcomType);
	
	}
	
	public ContactPointUse mapTelcomUse (java.lang.String telcomUse) {
		if(telcomUse == null || telcomUse.length() == 0) {
			return null;
		}
		telcomUse = telcomUse.toUpperCase();
		
		if (telcomUse.equals("HOME")) {
			return ContactPointUse.HOME;
		} else if (telcomUse.equals("WORK")) {
			return ContactPointUse.WORK;
		} else if (telcomUse.equals("TEMP")) {
			return ContactPointUse.TEMP;
		} else if (telcomUse.equals("OLD")) {
			return ContactPointUse.OLD;
		} else if (telcomUse.equals("MOBILE")) {
			return ContactPointUse.MOBILE;
		}

		throw new IllegalStateException("cannot find the ContactPointUse: " + telcomUse);
	}
	
	public NameUse mapHumanNameUse(java.lang.String nameUse) {
		if(nameUse == null || nameUse.length() == 0) {
			return null;
		}
		nameUse = nameUse.toUpperCase();
		
		if (nameUse.equals("OFFICIAL")) {
			return NameUse.OFFICIAL;
		} else if (nameUse.equals("USUAL")) {
			return NameUse.USUAL;
		} else if (nameUse.equals("TEMP")) {
			return NameUse.TEMP;
		} else if (nameUse.equals("NICKNAME")) {
			return NameUse.NICKNAME;
		} else if (nameUse.equals("OLD")) {
			return NameUse.OLD;
		} else if (nameUse.equals("ANONYMOUS")) {
			return NameUse.ANONYMOUS;
		} 
		
		throw new IllegalStateException("cannot find the NameUse: " + nameUse);
	}
	
	public AdministrativeGender mapGender(java.lang.String gender) {
		if(gender == null || gender.length() == 0) {
			return null;
		}
		gender = gender.toUpperCase();
		
		if (gender.equals("MALE")) {
			return AdministrativeGender.MALE;
		} else if (gender.equals("FEMALE")) {
			return AdministrativeGender.FEMALE;
		} else if (gender.equals("OTHER")) {
			return AdministrativeGender.OTHER;
		} else if (gender.equals("UNKNOWN")) {
			return AdministrativeGender.UNKNOWN;
		} 
		
		throw new IllegalStateException("cannot find the AdministrativeGender: " + gender);
	}
	
	public AdministrativeGender mapPatientGender(java.lang.String gender) {
		if(gender == null || gender.length() == 0) {
			return null;
		}
		
		if (gender.equals("0")) {
			return AdministrativeGender.MALE;
		} else if (gender.equals("1")) {
			return AdministrativeGender.FEMALE;
		} else if (gender.equals("2")) {
			return AdministrativeGender.OTHER;
		} else if (gender.equals("3")) {
			return AdministrativeGender.UNKNOWN;
		} 
		
		throw new IllegalStateException("cannot find the AdministrativeGender: " + gender);
	}
	
	public IdentifierUse mapIdentifierUse(java.lang.String use) {
		if(use == null || use.length() == 0) {
			return null;
		}
		use = use.toUpperCase();
		
		if (use.equals("OFFICIAL")) {
			return IdentifierUse.OFFICIAL;
		} else if (use.equals("USUAL")) {
			return IdentifierUse.USUAL;
		} else if (use.equals("TEMP")) {
			return IdentifierUse.TEMP;
		} else if (use.equals("SECONDARY")) {
			return IdentifierUse.SECONDARY;
		} 
		
		throw new IllegalStateException("cannot find the IdentifierUse: " + use);
	}
	
	public AddressUse mapAddressUse(java.lang.String addressUse) {
		if(addressUse == null || addressUse.length() == 0) {
			return null;
		}
		addressUse = addressUse.toUpperCase();
		
		if (addressUse.equals("HOME")) {
			return AddressUse.HOME;
		} else if (addressUse.equals("WORK")) {
			return AddressUse.WORK;
		} else if (addressUse.equals("TEMP")) {
			return AddressUse.TEMP;
		} else if (addressUse.equals("OLD")) {
			return AddressUse.OLD;
		} else if (addressUse.equals("BILLING")) {
			return AddressUse.BILLING;
		} 
		
		throw new IllegalStateException("cannot find the AddressUse: " + addressUse);
	}

	
	
	
}
