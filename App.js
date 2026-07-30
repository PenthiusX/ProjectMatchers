import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Pressable, ScrollView } from 'react-native';

function FeatureCard({ title, description }) {
  return (
    <View style={styles.card}>
      <Text style={styles.cardTitle}>{title}</Text>
      <Text style={styles.cardText}>{description}</Text>
    </View>
  );
}

export default function App() {
  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.brand}>DatingAppAI</Text>
      <Text style={styles.title}>Smart matches, made effortless.</Text>
      <Text style={styles.subtitle}>
        Build a better dating profile, connect with more people, and get matched with confidence using AI-powered insights.
      </Text>

      <Pressable style={styles.ctaButton} onPress={() => {}}>
        <Text style={styles.ctaText}>Get Started</Text>
      </Pressable>

      <View style={styles.features}>
        <FeatureCard
          title="Personalized Profiles"
          description="Create a profile that stands out with AI-guided prompts and personality highlights."
        />
        <FeatureCard
          title="Smart Matchmaking"
          description="Discover better matches through intelligent recommendations and interest-based filters."
        />
        <FeatureCard
          title="Fast Setup"
          description="Launch your dating presence quickly with a clean, mobile-first landing experience."
        />
      </View>

      <Text style={styles.footer}>Built with Expo & React Native for Android.</Text>
      <StatusBar style="auto" />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    paddingTop: 80,
    paddingHorizontal: 24,
    paddingBottom: 40,
    backgroundColor: '#090a17',
    minHeight: '100%',
  },
  brand: {
    color: '#7c3aed',
    fontSize: 18,
    fontWeight: '700',
    letterSpacing: 1.2,
    marginBottom: 14,
  },
  title: {
    color: '#181616',
    fontSize: 34,
    fontWeight: '800',
    lineHeight: 42,
    marginBottom: 16,
  },
  subtitle: {
    color: '#c7d2fe',
    fontSize: 16,
    lineHeight: 24,
    marginBottom: 28,
  },
  ctaButton: {
    backgroundColor: '#8b5cf6',
    paddingVertical: 16,
    borderRadius: 14,
    alignItems: 'center',
    marginBottom: 28,
  },
  ctaText: {
    color: '#ffffff',
    fontSize: 16,
    fontWeight: '700',
  },
  features: {
    gap: 16,
  },
  card: {
    backgroundColor: '#111827',
    borderRadius: 20,
    padding: 20,
    marginBottom: 16,
    shadowColor: '#000',
    shadowOpacity: 0.16,
    shadowRadius: 18,
    elevation: 4,
  },
  cardTitle: {
    color: '#ffffff',
    fontSize: 18,
    fontWeight: '700',
    marginBottom: 8,
  },
  cardText: {
    color: '#c7d2fe',
    fontSize: 14,
    lineHeight: 20,
  },
  footer: {
    marginTop: 28,
    color: '#94a3b8',
    fontSize: 12,
    textAlign: 'center',
  },
});
