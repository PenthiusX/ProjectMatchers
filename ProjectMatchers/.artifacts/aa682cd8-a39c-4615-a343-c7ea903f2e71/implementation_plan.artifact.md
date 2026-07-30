# Implementation Plan: Tinder/Bumble Style Dating App

This plan outlines the creation of a modular dating app UI in Jetpack Compose, featuring a swipe-able card stack similar to Tinder and Bumble.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/gradle/libs.versions.toml)
- Add Coil for image loading.
- Add Material Icons Extended for UI icons.

#### [MODIFY] [build.gradle.kts](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/build.gradle.kts)
- Add the new libraries to the dependencies block.

### Data Layer

#### [NEW] [UserProfile.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/data/model/UserProfile.kt)
- Define a data class `UserProfile` with fields like `id`, `name`, `age`, `bio`, and `imageUrl`.

### UI Components (Modular)

#### [NEW] [ProfileCard.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/ui/components/ProfileCard.kt)
- A stateless composable to display an individual profile image and information.

#### [NEW] [SwipeCardStack.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/ui/components/SwipeCardStack.kt)
- A component that manages a stack of `ProfileCard`s.
- Implements custom swipe logic (Left/Right) using `detectDragGestures`.
- Handles card animations (translation, rotation, alpha).

#### [NEW] [ActionButtons.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/ui/components/ActionButtons.kt)
- A row of buttons (Dislike, Like, Undo) to interact with the current card.

### Main Feature Screen

#### [NEW] [DiscoveryScreen.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/ui/discovery/DiscoveryScreen.kt)
- Orchestrates the `SwipeCardStack` and `ActionButtons`.
- Manages the list of profiles and the "No more profiles" state.

#### [MODIFY] [MainActivity.kt](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/java/com/example/projectmatchers/MainActivity.kt)
- Set the content to `DiscoveryScreen`.

## Verification Plan

### Automated Tests
- N/A for initial UI layout, but unit tests for data models could be added later.

### Manual Verification
- Run the app on the connected device.
- Verify that cards can be swiped left and right.
- Verify that swiping right triggers a "Like" animation/effect.
- Verify that swiping left triggers a "Dislike" animation/effect.
- Verify that the Action Buttons trigger the same swipe logic.
- Verify that the list updates correctly after a swipe.
