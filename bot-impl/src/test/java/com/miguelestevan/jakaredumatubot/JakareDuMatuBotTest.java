package com.miguelestevan.jakaredumatubot;

import com.bueno.spi.model.CardRank;
import com.bueno.spi.model.CardSuit;
import com.bueno.spi.model.GameIntel;
import com.bueno.spi.model.TrucoCard;
import com.cremonezzi.impl.carlsenbot.Carlsen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JakareDuMatuBotTest {

    private JakareDuMatuBot jakareDuMatuBot;

    @BeforeEach
    public void config() {
        jakareDuMatuBot = new JakareDuMatuBot();
    }

    @Nested
    class getMaoDeOnzeResponse {

    }

    @Nested
    @DisplayName("Decide If Raises Request Point tests")
    class decideIfRaises {
        // First Hand
        @Test
//        @DisplayName("Decide que vai pedir truco na primeira rodada com casal maior")
        @DisplayName("Decide that you will ask for tricks in the first round with an older couple")
        public void DecideThatYouWillAskForTricksInTheFirstRoundWithAnOlderCouple(){
            TrucoCard vira = TrucoCard.of(CardRank.JACK, CardSuit.DIAMONDS);

            // Game info
            List<GameIntel.RoundResult> roundResults = List.of();
            List<TrucoCard> openCards = List.of(vira);

            // Bot info
            List<TrucoCard> botCards = List.of(
                    TrucoCard.of(CardRank.KING, CardSuit.CLUBS),
                    TrucoCard.of(CardRank.TWO, CardSuit.SPADES),
                    TrucoCard.of(CardRank.KING, CardSuit.HEARTS)
            );

            GameIntel intel = GameIntel.StepBuilder.with()
                    .gameInfo(roundResults, openCards, vira, 1)
                    .botInfo(botCards, 5)
                    .opponentScore(2)
                    .build();

            assertThat(jakareDuMatuBot.decideIfRaises(intel)).isEqualTo(true);
        }

        // Second Hand
    }

    @Nested
    class chooseCard {
    }

    @Nested
    class getRaiseResponse {
    }

    @Nested
    @DisplayName("getName Tests")
    class getName {
        @Test
        @DisplayName("Should name of Bot jakareDuMatuBot")
        public void showNameOfJakareDuMatuBot(){
            assertEquals(jakareDuMatuBot.getName(), "JakaréDuMatuBóty");
        }

    }

}