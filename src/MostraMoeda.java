import java.util.Map;

public record MostraMoeda(Map<String, Double> conversion_rates, String base_code) {
}
