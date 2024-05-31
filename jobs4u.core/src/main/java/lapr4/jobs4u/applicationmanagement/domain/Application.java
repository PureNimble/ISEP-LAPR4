package lapr4.jobs4u.applicationmanagement.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

/**
 * @author 2DI2
 */
@Entity
@Table(name = "T_APPLICATION")
public class Application implements AggregateRoot<ApplicationCode>, Runnable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private ApplicationCode applicationCode;

    @Column(nullable = false)
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private Result result;

    @CollectionTable(name = "T_APPLICATION_FILE")
    @ElementCollection
    private List<File> file;

    @ManyToOne(optional = false)
    @JoinColumn(name = "JobOpening")
    private JobOpening jobOpening;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Candidate")
    private Candidate candidate;

    @Transient
    private Map<String, Pair<Integer, Set<String>>> topWords;

    Application(final Date date, final ApplicationCode applicationCode, final List<File> file,
            final JobOpening jobOpening, final Candidate candidate, final Result result) {
        Preconditions.noneNull(new Object[] { date, applicationCode, file, jobOpening, candidate, result });
        this.date = date;
        this.applicationCode = applicationCode;
        this.file = file;
        this.jobOpening = jobOpening;
        this.candidate = candidate;
        this.result = result;
    }

    protected Application() {
        // for ORM only
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public ApplicationCode applicationCode() {
        return identity();
    }

    public Candidate candidate() {
        return this.candidate;
    }

    public List<File> getFiles() {
        return this.file;
    }

    public Result result() {
        return this.result;
    }

    public ApplicationDTO toDTO() {
        return new ApplicationDTO(applicationCode.toString(), candidate.toString(), result.outcome.toString());
    }

    public void addResult(String outcome) {
        this.result.addOutcome(outcome);
    }

    public void addResult(String outcome, String justification) {
        this.result.addOutcome(outcome, justification);
    }

    @Override
    public ApplicationCode identity() {
        return this.applicationCode;
    }

    public JobOpening jobOpening() {
        return this.jobOpening;
    }

    @Override
    public void run() {
        topWords = new HashMap<>();
        List<Thread> threads = new ArrayList<>();
        for (File f : file) {
            Thread thread = new Thread(f);
            threads.add(thread);
            thread.start();
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        file.forEach(f -> {
            f.getTopWords().entrySet().forEach(entry -> {
                Pair<Integer, Set<String>> pair = topWords.getOrDefault(entry.getKey(),
                        Pair.of(0, new HashSet<String>()));
                Set<String> files = pair.getSecond();
                files.add(f.fileName());
                Integer value = pair.getFirst() + entry.getValue();
                addToMap(entry.getKey(), Pair.of(value, files));
            });
        });

        synchronized (topWords) {
            topWords = topWords.entrySet().stream()
                    .sorted(Map.Entry.<String, Pair<Integer, Set<String>>>comparingByValue(
                            Comparator.comparingInt(Pair::getFirst)).reversed())
                    .limit(20).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }

    }

    private synchronized void addToMap(String word, Pair<Integer, Set<String>> pair) {
        topWords.put(word, pair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Application Code: ").append(applicationCode).append("\n");
        sb.append("Top 20 Words:\n");
        topWords.entrySet().forEach(entry -> {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        });
        return sb.toString();
    }

}
