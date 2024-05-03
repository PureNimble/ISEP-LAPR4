package lapr4.jobs4u.candidatemanagement.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;

@Component
public class ListCandidatesService {

    private final CandidateRepository candidateRepository;

    public ListCandidatesService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Iterable<CandidateDTO> allUsers() {
        final Iterable<Candidate> candidates = this.candidateRepository.findAll();

        List<CandidateDTO> CandidatesDTO = new ArrayList<>();
        candidates.forEach(candidate -> CandidatesDTO.add(candidate.toDTO()));

        return CandidatesDTO;
    }

    public Iterable<CandidateDTO> allUsersSortedAsc() {
        final Iterable<Candidate> candidates = this.candidateRepository.sortedAsc();
        List<CandidateDTO> CandidatesDTO = new ArrayList<>();
        candidates.forEach(candidate -> CandidatesDTO.add(candidate.toDTO()));

        return CandidatesDTO;
    }

    public Candidate selectedCandidate(CandidateDTO candidateDTO) {
        Candidate selectedCandidate = candidateRepository
            .ofIdentity(EmailAddress.valueOf(candidateDTO.getEmail()))
            .orElseThrow(IllegalArgumentException::new);
        return selectedCandidate;
    }
}
